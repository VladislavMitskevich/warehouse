package com.example.warehouse.repository;

import com.example.warehouse.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for Product entities.
 * Provides methods for basic CRUD operations and custom queries.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds products by their active status.
     *
     * @param active - the active status of the product.
     * @return a list of products with the given active status.
     */
    List<Product> findByActive(Boolean active);
}
