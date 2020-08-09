package shop.web.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shop.annotation.PageTitle;
import shop.models.views.OrderViewModel;
import shop.service.OrderService;
import shop.tools.ListShop;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

	private final OrderService orderService;
    @SuppressWarnings("unused")
	private final ModelMapper modelMapper;
    private final ListShop listShop;

    public OrderController(OrderService orderService, ModelMapper modelMapper, ListShop listShop) {
        this.orderService = orderService;
        this.modelMapper = modelMapper;
        this.listShop = listShop;
    }

    @PageTitle(name = "Orders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER')")
    @GetMapping("/all")
    public String orders(Model model){
        List<OrderViewModel> allOrders = this.listShop.getAllOrders();
        model.addAttribute("allOrders", allOrders);
        return "order/order_all";
    }
    
    @PageTitle(name = "Orders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER')")
    @GetMapping("/detail")
    public String orderDetail(Model model){
        return "order/order_detail";
    }
    
    @PageTitle(name = "Orders")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'MANAGER', 'WORKER')")
    @GetMapping("/delete/{orderId}")
    public String orderDelete(@PathVariable("orderId") String orderId){
        this.orderService.deleteOrder(orderId);
        return "redirect:/order/all";
    }

}
