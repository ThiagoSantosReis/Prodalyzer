package com.orders.ordermnagement.repository;

import com.orders.ordermnagement.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
