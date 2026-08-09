package com.sl.orderservice.repository;

import com.sl.orderservice.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(String userId);

    Optional<CartItem> findByUserIdAndDishId(String userId, String dishId);

    void deleteByUserId(String userId);
}

