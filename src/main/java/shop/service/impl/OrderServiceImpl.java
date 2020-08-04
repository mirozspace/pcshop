package shop.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.error.UserIsNotExistException;
import shop.models.entities.Order;
import shop.models.entities.Product;
import shop.models.entities.User;
import shop.models.service.OrderServiceModel;
import shop.repository.OrderRepository;
import shop.repository.UserRepository;
import shop.service.interfaces.OrderService;
import shop.service.interfaces.UserService;
import shop.tools.Tools;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private final Tools tools;
    @SuppressWarnings({"unused", "FieldCanBeLocal"})
	private final UserService userService;
    private final UserRepository userRepository;

    @Autowired
    public OrderServiceImpl(ModelMapper modelMapper, OrderRepository orderRepository,
                            Tools tools, UserService userService, UserRepository userRepository) {
        this.modelMapper = modelMapper;
        this.orderRepository = orderRepository;
        this.tools = tools;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void addOrder() throws UserIsNotExistException {
        User user = this.userRepository.findByUsername(this.tools.getLoggedUser()).orElse(null);
        if (user != null && user.getBoughtProducts().size() > 0) {
            List<Product> products = user.getBoughtProducts();
            for (Product product : products) {
                this.orderRepository.saveAndFlush(
                        new Order(
                                product.getSku(),
                                product.getEan(),
                                product.getName(),
                                product.getPrice().doubleValue(),
                                user.getUsername(),
                                user.getFirstName(),
                                user.getLastName(),
                                user.getPhoneNumber(),
                                user.getAddress().getCountry(),
                                user.getAddress().getCity(),
                                user.getAddress().getPostCode(),
                                user.getAddress().getStreet(),
                                user.getAddress().getStreetNumb()
                        ));
            }
            user.getBoughtProducts().clear();
            this.userRepository.saveAndFlush(user);
        } else {
            throw new UserIsNotExistException("User is not exist!");
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        this.orderRepository.deleteById(orderId);
    }

    @Override
    public List<OrderServiceModel> getAllOrders() {
        return this.orderRepository.findAll().stream()
                .map(o -> this.modelMapper.map(o, OrderServiceModel.class))
                .collect(Collectors.toList());
    }
}
