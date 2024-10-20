package com.example.warehouse.service;

import com.example.warehouse.dto.ProductDTO;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {
    List<ProductDTO> getAllProducts();
    ProductDTO getProductById(Long productId);
    ProductDTO createProduct(ProductDTO productDTO);
}
