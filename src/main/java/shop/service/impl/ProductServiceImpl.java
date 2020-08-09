package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import shop.error.category.CategoryIsNotExistExceprion;
import shop.error.manufacturer.ManufacturerIsNotExistException;
import shop.error.product.ProductIsNotExistException;
import shop.models.entities.Category;
import shop.models.entities.Manufacturer;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.models.service.ProductServiceModel;
import shop.repository.ManufacturerRepository;
import shop.repository.ProductRepository;
import shop.repository.CategoryRepository;
import shop.repository.UserRepository;
import shop.service.CloudinaryService;
import shop.service.ProductService;
import shop.util.DefaultProductInformation;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ManufacturerRepository manufacturerRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ManufacturerRepository manufacturerRepository,
                              CategoryRepository categoryRepository, UserRepository userRepository, ModelMapper modelMapper, CloudinaryService cloudinaryService) {
        this.productRepository = productRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.cloudinaryService = cloudinaryService;
    }

    @Override
    public ProductServiceModel addProduct(ProductServiceModel psm) throws IOException {
        //SECURITY!!!
        Product product = this.modelMapper.map(psm, Product.class);
        Category c = this.categoryRepository.findByName(psm.getCategoryF());
        Manufacturer m = this.manufacturerRepository.findByName(psm.getManufacturerF());
        product.setManufacturer(m);
        product.setCategory(c);
        System.out.println();
        for (MultipartFile photo : psm.getPhotos()) {
            if (!photo.isEmpty()) {
                List<String> productURLs = new ArrayList<>();
                String imgUrl = this.cloudinaryService.uploadImage(photo);
                productURLs.add(imgUrl);
                product.setImageUrls(productURLs);
            } else {
                product.setImageUrls(new ArrayList<>());
                product.getImageUrls().add("http://stefchev.com/files/osc/product.png");
            }
            break;
        }

        Product savedProduct = this.productRepository.saveAndFlush(product);
        return this.modelMapper.map(savedProduct, ProductServiceModel.class);
    }


    @Override
    public ProductServiceModel updateProduct(ProductServiceModel psm) throws IOException {
        Product product = this.productRepository.findById(psm.getId()).orElse(null);
        if (product == null) {
            throw new ProductIsNotExistException("Product " + psm.getName() + " is not exist!");
        }
        product.setName(psm.getName());
        product.setMake(psm.getMake());
        product.setModel(psm.getModel());
        product.setDescription(psm.getDescription());
        product.setSku(psm.getSku());
        product.setEan(psm.getEan());
        product.setQuantity(psm.getQuantity());
        product.setPrice(psm.getPrice());
        Category c = this.categoryRepository.findByName(psm.getCategoryF());
        Manufacturer m = this.manufacturerRepository.findByName(psm.getManufacturerF());
        product.setManufacturer(m);
        product.setCategory(c);
        product.setProductCondition(psm.getProductCondition());

        for (MultipartFile photo : psm.getPhotos()) {
            if (!photo.isEmpty()) {
            	
            	product.getImageUrls().clear();
                //List<String> productURLs = new ArrayList<>();
                String imgUrl = this.cloudinaryService.uploadImage(photo);
                product.getImageUrls().add(imgUrl);
                //productURLs.clear();
                //productURLs.add(imgUrl);
                ////productURLs.set(0, imgUrl);
                //product.setImageUrls(productURLs);
                break;
            }
        }

        Product savedProduct = this.productRepository.saveAndFlush(product);
        return this.modelMapper.map(savedProduct, ProductServiceModel.class);

    }

    @Override
    public List<ProductServiceModel> getAllProduct() {
        return this.productRepository.findAll()
                .stream()
                .map(product -> this.modelMapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductServiceModel> getAllProductByCategory(String category) {
        return null;
    }

    @Override
    public boolean deleteProductFromDbById(String productId) {
        List<User> users = this.userRepository.findAll();
        for (User user : users) {
            List<Product> buyedProducts = user.getBoughtProducts().stream()
                    .filter(p -> !p.getId().equals(productId)).collect(Collectors.toList());
            user.setBoughtProducts(buyedProducts);
            this.userRepository.saveAndFlush(user);
        }
        Product product = this.productRepository.findById(productId).orElse(null);
        product.setImageUrls(new ArrayList<String>());
        product.setCategory(null);
        this.productRepository.saveAndFlush(product);
        this.productRepository.deleteById(productId);
        return true;
    }

    @Override
    public ProductServiceModel findByProductId(String productId) {
        Product product = this.productRepository.findById(productId).orElse(null);
        if(product == null){
            throw new ProductIsNotExistException("Product is not exist!");
        }
        return this.modelMapper.map(product, ProductServiceModel.class);
    }

    @Override
    public boolean addDefaultProducts() {
        if (this.productRepository.count() == 0) {
            Category category = null;
            Manufacturer manufacturer = null;
            for (DefaultProductInformation value : DefaultProductInformation.values()) {
                category = this.categoryRepository.findByName(value.getCategory());
                if(category == null){
                    throw new CategoryIsNotExistExceprion("Category is not exist!");
                }
                manufacturer = this.manufacturerRepository.findByName(value.getManufacturer());
                if (manufacturer == null){
                    throw new ManufacturerIsNotExistException("Manufacturer is not exist!");
                }
                Product pr = new Product(
                        value.getName(),
                        value.getDescription(),
                        value.getMake(),
                        value.getModel(),
                        value.getSku(),
                        value.getEan(),
                        value.getPrice(),
                        value.getQuantity(),
                        value.getProductCondition(),
                        category,
                        manufacturer,
                        value.getImageUrl()
                );
                this.productRepository.saveAndFlush(pr);
            }
        }
        return true;
    }

    @Override
    public boolean deleteAllProducts() {
        this.productRepository.deleteAll();
        return true;
    }

    /* PRIVATE METHODS */
    public static String getPathForLocalInFileSystem() {
        return System.getProperty("user.dir")
                + File.separator + "src"
                + File.separator + "main"
                //+ File.separator + "resources"
                + File.separator + "upload"
                + File.separator + "img"
                + File.separator + "products";
    }

    @SuppressWarnings("unused")
	private static String getMadeLink() {
        return "/src/main/resources/static/img/products//";
    }

    /* PRIVATE METHODS */
    @SuppressWarnings("unused")
	private static String getBaseFilePathString3() {
        return "C:" + File.separator + "photos";
    }

}




























    /*
        @Override
        public ProductServiceModel addProduct(ProductServiceModel psm) throws IOException {
            //SECURITY!!!
            Product product = this.modelMapper.map(psm, Product.class);
            Category c = this.categoryRepository.findByName(psm.getCategoryF());
            Manufacturer m = this.manufacturerRepository.findByName(psm.getManufacturerF());
            product.setManufacturer(m);
            product.setCategory(c);
            if (psm.getPhotos().length > 0) {
                String uploadFolder = getPathForLocalInFileSystem();
                List<String> productURLs = new ArrayList<>();
                for (MultipartFile photo : psm.getPhotos()) {
                    String productPathStr = uploadFolder + File.separator + psm.getMake() + psm.getModel() + File.separator;
                    String productURL = "/img/products/" + psm.getMake() + psm.getModel() + "/" + photo.getOriginalFilename();
                    productURLs.add(productURL);
                    Path productPath = Paths.get(productPathStr);
                    if (Files.notExists(productPath)) Files.createDirectories(productPath);
                    productPathStr = productPathStr + photo.getOriginalFilename();
                    Path p = Paths.get(productPathStr);
                    Files.write(p, photo.getBytes());
                    product.setImageUrls(productURLs);
                }
            } else {
                product.setImageUrls(new ArrayList<>());
                product.getImageUrls().add("/img/product.png");
            }
        Product savedProduct = this.productRepository.saveAndFlush(product);
        return this.modelMapper.map(savedProduct, ProductServiceModel.class);
    }*/