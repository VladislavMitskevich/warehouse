package com.example.warehouse.repository;

import com.example.warehouse.model.SKU;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for SKU entities.
 * Provides methods for basic CRUD operations and custom queries.
 */
@Repository
public interface SKURepository extends JpaRepository<SKU, Long> {

    /**
     * Finds SKUs by availability status.
     *
     * @param available - the availability status of the SKU.
     * @return a list of SKUs with the given availability status.
     */
    List<SKU> findByAvailable(Boolean available);

    /**
     * Finds SKUs by their color.
     *
     * @param color - the color of the SKU.
     * @return a list of SKUs with the specified color.
     */
    List<SKU> findByColor(String color);
}
