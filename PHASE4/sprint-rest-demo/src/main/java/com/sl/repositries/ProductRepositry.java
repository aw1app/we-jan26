package com.sl.repositries;

import com.sl.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositry extends JpaRepository<Product, Integer>{
}
