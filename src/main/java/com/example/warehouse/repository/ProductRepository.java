package com.example.warehouse.repository;

import com.example.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for Product entity.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
