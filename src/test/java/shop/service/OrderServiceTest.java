package shop.service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import shop.models.entities.Order;
import shop.models.service.OrderServiceModel;
import shop.repository.OrderRepository;
import shop.repository.UserRepository;
import shop.service.impl.OrderServiceImpl;
import shop.tools.Tools;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @InjectMocks
    private ModelMapper modelMapper;
    @MockBean
    private OrderRepository orderRepository;
    @MockBean
    private Tools tools;
    @MockBean
    private UserService userService;
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private OrderService orderService;

    @Test
    void deleteOrder() {
    }

    private Order getOrder() {
        Order o = new Order();
        o.setId("ksjdf-7jds-skjdf");
        o.setProductSku("345837nd8");
        o.setProductEan("345837nd8");
        o.setProductName("Dell Tower 745");
        o.setPrice(99.99);
        o.setNote("Some note");
        o.setUsername("desito");
        o.setFirstName("Desislava");
        o.setLastName("Ivanova");
        o.setPhoneNumber("+359000000000");
        o.setUserCountry("Bulgaria");
        o.setUserCity("Sofia");
        o.setUserPostCode("1000");
        o.setUserStreet("Vitoshka");
        o.setUserStreetNumber("1A");
        return o;
    }
}