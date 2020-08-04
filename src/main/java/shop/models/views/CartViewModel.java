package shop.models.views;

import java.util.List;

public class CartViewModel extends BaseViewModel {

	private List<ProductViewModel> productsViewModel;

	/**
	 * 
	 */
	public CartViewModel() {
		super();
	}

	/**
	 * @return the productsViewModel
	 */
	public List<ProductViewModel> getProductsViewModel() {
		return productsViewModel;
	}

	/**
	 * @param productsViewModel the productsViewModel to set
	 */
	public void setProductsViewModel(List<ProductViewModel> productsViewModel) {
		this.productsViewModel = productsViewModel;
	}
	
	
	
}
