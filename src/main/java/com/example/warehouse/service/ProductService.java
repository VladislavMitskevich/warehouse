package com.example.warehouse.service;

import com.example.warehouse.model.Product;

import java.util.List;

/**
 * Service interface for managing products.
 */
public interface ProductService {

    /**
     * Gets all active products.
     *
     * @return a list of active products.
     */
    List<Product> getAllActiveProducts();

    /**
     * Saves or updates a product.
     *
     * @param product - the product to save or update.
     * @return the saved or updated product.
     */
    Product saveProduct(Product product);

    /**
     * Finds a product by its ID.
     *
     * @param id - the ID of the product.
     * @return the product with the specified ID.
     */
    Product getProductById(Long id);
}
