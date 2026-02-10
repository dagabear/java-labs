package kz.moderntech.controller;

import kz.moderntech.controller.base.BaseController;
import kz.moderntech.model.Order;
import kz.moderntech.repository.OrderRepository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderController extends BaseController<Order, Long> {

    private final OrderRepository orderRepository;

    public OrderController(OrderRepository repository) {
        super(repository);
        this.orderRepository = repository;
    }

    @PatchMapping("/update-status/{id}/{status}")
    public void updateOrderStatus(@PathVariable Long id, @PathVariable String status) {
        var order = super.findById(id);
        order.setStatus(status);
        orderRepository.save(order);
    }

    @GetMapping("/find-by-status/{status}")
    public List<Order> findOrdersByStatus(@PathVariable String status) {
        return orderRepository.findOrdersByStatus(status);
    }

}
