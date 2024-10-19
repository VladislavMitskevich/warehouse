package com.example.warehouse.service;

import com.example.warehouse.dto.ProductDTO;
import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO getProductById(Long id);
    List<ProductDTO> getAllProducts();
    ProductDTO updateProduct(Long id, ProductDTO productDTO);
    void deleteProduct(Long id);
}
