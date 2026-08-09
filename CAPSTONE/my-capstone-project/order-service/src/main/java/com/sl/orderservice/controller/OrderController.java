package com.sl.orderservice.controller;

import com.sl.orderservice.model.CartItem;
import com.sl.orderservice.model.Order;
import com.sl.orderservice.model.OrderItem;
import com.sl.orderservice.repository.CartItemRepository;
import com.sl.orderservice.repository.OrderItemRepository;
import com.sl.orderservice.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        for (Order order : orders) {
            order.setOrderItems(orderItemRepository.findByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @GetMapping("/orders/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable String userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        for (Order order : orders) {
            order.setOrderItems(orderItemRepository.findByOrderId(order.getOrderId()));
        }
        return orders;
    }

    @PostMapping("/checkout")
    @Transactional
    public ResponseEntity<Order> checkout(@RequestBody Order orderRequest) {
        List<CartItem> cartItems = cartItemRepository.findByUserId(orderRequest.getUserId());
        if (cartItems.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        double subTotal = 0;
        int totalItems = 0;
        for (CartItem item : cartItems) {
            subTotal += item.getPrice() * item.getQuantity();
            totalItems += item.getQuantity();
        }

        double shipping = 40.0;
        double totalAmount = subTotal + shipping;

        Order newOrder = new Order();
        newOrder.setUserId(orderRequest.getUserId());
        newOrder.setName(orderRequest.getName());
        newOrder.setContact(orderRequest.getContact());
        newOrder.setEmail(orderRequest.getEmail());
        newOrder.setAddress(orderRequest.getAddress());
        newOrder.setItemsSubTotal(subTotal);
        newOrder.setShipmentCharges(shipping);
        newOrder.setTotalAmount(totalAmount);
        newOrder.setTotalItems(totalItems);
        newOrder.setOrderDate(new Date());
        newOrder.setOrderStatus("Placed");
        newOrder.setPaymentMethod(orderRequest.getPaymentMethod() != null ? orderRequest.getPaymentMethod() : "COD");
        newOrder.setPaymentStatus("SUCCESS");

        Order savedOrder = orderRepository.save(newOrder);

        List<OrderItem> orderItems = new ArrayList<>();
        for (CartItem item : cartItems) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(savedOrder.getOrderId());
            orderItem.setProductId(item.getDishId());
            orderItem.setProductTitle(item.getDishName());
            orderItem.setPrice(item.getPrice());
            orderItem.setQuantity(item.getQuantity());
            orderItem.setTotalPrice(item.getPrice() * item.getQuantity());
            orderItems.add(orderItemRepository.save(orderItem));
        }

        savedOrder.setOrderItems(orderItems);
        cartItemRepository.deleteByUserId(orderRequest.getUserId());

        return ResponseEntity.ok(savedOrder);
    }
}

