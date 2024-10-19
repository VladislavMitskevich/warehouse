package com.example.warehouse.service;

import com.example.warehouse.dto.ProductDTO;
import java.util.List;

/**
 * Interface for Product service to handle product-related operations.
 */
public interface ProductService {

    /**
     * Creates a new product.
     *
     * @param productDto the product data transfer object.
     * @return the created product as a DTO.
     */
    ProductDTO createProduct(ProductDTO productDto);

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product.
     * @return the corresponding product DTO.
     */
    ProductDTO getProductById(Long id);

    /**
     * Retrieves all products.
     *
     * @return a list of all product DTOs.
     */
    List<ProductDTO> getAllProducts();

    /**
     * Updates an existing product.
     *
     * @param id the ID of the product to update.
     * @param productDto the updated product data transfer object.
     * @return the updated product as a DTO.
     */
    ProductDTO updateProduct(Long id, ProductDTO productDto);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete.
     */
    void deleteProduct(Long id);

    /**
     * Searches for products by name in Elasticsearch.
     *
     * @param name the keyword to search for.
     * @return a list of product DTOs that match the search criteria.
     */
    List<ProductDTO> searchProductsByName(String name);
}
