package shop.service.interfaces;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.mock.mockito.MockBean;
import shop.models.entities.Order;
import shop.repository.OrderRepository;
import shop.repository.UserRepository;
import shop.service.impl.OrderServiceImpl;
import shop.tools.Tools;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @MockBean
    private OrderRepository mockedOrderRepository;
    private ModelMapper modelMapper;
    private OrderService orderService;
    @MockBean
    private Tools tools;
    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository mockedUserRepository;

    @BeforeEach
    public void setup(){
        this.modelMapper = new ModelMapper();
        this.orderService = new OrderServiceImpl(this.modelMapper, this.mockedOrderRepository,
                this.tools, this.userService, this.mockedUserRepository);
    }


    @Test
    void deleteOrder() {
    }

    @Test
    void getAllOrders() {
    }

    private Order getorder(){
        Order order = new Order();
        order.setProductSku("37452dfg");
        order.setProductEan("KJhd8763");
        order.setProductName("Dell Tower 745");
        order.setPhoneNumber("+359000000000");
        order.setUsername("desito");
        order.setFirstName("Desislava");
        order.setLastName("Ivanova");
        order.setUserCountry("Bulgaria");
        order.setUserCity("Sofia");
        order.setUserPostCode("1000");
        order.setUserStreet("Vitoshka");
        order.setUserStreetNumber("1000");
        order.setNote("Some Note");
        double price = 199.99;
        return order;
    }
}