package lk.kvrp.creatorstore.controllers;

import jakarta.validation.Valid;
import lk.kvrp.creatorstore.dto.OrderRequest;
import lk.kvrp.creatorstore.entities.Order;
import lk.kvrp.creatorstore.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public Order createOrder(@Valid @RequestBody OrderRequest orderRequest) {
        return orderService.createOrder(orderRequest);
    }

    // Get all orders
    public List<Order> getAllOrders() {
        // TODO: to be implement
        return null;
    }

    // Get order by id
    public Order getOrderById() {
        // TODO: to be implement
        return null;
    }
}
