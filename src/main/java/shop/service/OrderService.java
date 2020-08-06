package shop.service;

import shop.error.user.UserIsNotExistException;
import shop.models.service.OrderServiceModel;

import java.util.List;

public interface OrderService {

    boolean saveOrders() throws UserIsNotExistException;

    boolean deleteOrder(String orderId);

    List<OrderServiceModel> getAllOrders();

}
