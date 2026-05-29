package com.trading.controller;



import com.trading.dto.OrderRequest;
import com.trading.dto.OrderResponse;
import com.trading.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
@CrossOrigin("*")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/buy")
    public OrderResponse placeBuyOrder(@Valid @RequestBody OrderRequest request) {
        return orderService.placeBuyOrder(request);
    }

    @PostMapping("/sell")
    public OrderResponse placeSellOrder(@Valid @RequestBody OrderRequest request) {
        return orderService.placeSellOrder(request);
    }

    @GetMapping
    public List<OrderResponse> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/user/{userId}")
    public List<OrderResponse> getUserOrders(@PathVariable Long userId) {
        return orderService.getUserOrders(userId);
    }

    @DeleteMapping("/{id}")
    public String cancelOrder(@PathVariable Long id) {
        orderService.cancelOrder(id);
        return "Order cancelled successfully";
    }

}
