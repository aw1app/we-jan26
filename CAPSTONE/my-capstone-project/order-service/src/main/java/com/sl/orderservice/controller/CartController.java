package com.sl.orderservice.controller;

import com.sl.orderservice.model.CartItem;
import com.sl.orderservice.repository.CartItemRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin(origins = "*")
public class CartController {

    @Autowired
    private CartItemRepository cartItemRepository;

    @GetMapping("/user/{userId}")
    public List<CartItem> getCartByUser(@PathVariable String userId) {
        return cartItemRepository.findByUserId(userId);
    }

    @PostMapping("/add")
    public CartItem addToCart(@RequestBody CartItem cartItem) {
        Optional<CartItem> existingOpt = cartItemRepository.findByUserIdAndDishId(cartItem.getUserId(), cartItem.getDishId());
        if (existingOpt.isPresent()) {
            CartItem existing = existingOpt.get();
            existing.setQuantity(existing.getQuantity() + cartItem.getQuantity());
            return cartItemRepository.save(existing);
        }
        return cartItemRepository.save(cartItem);
    }

    @PutMapping("/update")
    public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem) {
        return cartItemRepository.findById(cartItem.getCartId())
                .map(existing -> {
                    existing.setQuantity(cartItem.getQuantity());
                    return ResponseEntity.ok(cartItemRepository.save(existing));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartId) {
        if (cartItemRepository.existsById(cartId)) {
            cartItemRepository.deleteById(cartId);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/clear/{userId}")
    @Transactional
    public ResponseEntity<Void> clearCart(@PathVariable String userId) {
        cartItemRepository.deleteByUserId(userId);
        return ResponseEntity.noContent().build();
    }
}

