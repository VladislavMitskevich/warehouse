package com.example.warehouse.repository;

import com.example.warehouse.model.SKU;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository interface for SKU entity.
 */
public interface SKURepository extends JpaRepository<SKU, Long> {
}
