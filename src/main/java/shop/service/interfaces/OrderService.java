package shop.service.interfaces;

import shop.error.UserIsNotExistException;
import shop.models.service.OrderServiceModel;

import java.util.List;

public interface OrderService {

    /**
     * Adds new order to db
     * @throws UserIsNotExistException
     */
    void addOrder() throws UserIsNotExistException;

    /**
     * delete order from db
     * @param orderId
     */
    void deleteOrder(String orderId);

    /**
     * Get all made orders
     * @return List<OrderServiceModel>
     */
    List<OrderServiceModel> getAllOrders();

}
