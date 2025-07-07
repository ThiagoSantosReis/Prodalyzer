package com.orders.ordermnagement.repository;

import com.orders.ordermnagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p,c FROM Product p JOIN p.category c  WHERE p.price >= :price")
    List<Product> findByPriceGreaterThan(double price);
}
