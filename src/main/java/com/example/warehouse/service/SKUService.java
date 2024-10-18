package com.example.warehouse.service;

import com.example.warehouse.model.SKU;

import java.util.List;

/**
 * Service interface for managing SKUs.
 */
public interface SKUService {

    /**
     * Gets all available SKUs.
     *
     * @return a list of available SKUs.
     */
    List<SKU> getAllAvailableSKUs();

    /**
     * Saves or updates an SKU.
     *
     * @param sku - the SKU to save or update.
     * @return the saved or updated SKU.
     */
    SKU saveSKU(SKU sku);

    /**
     * Finds an SKU by its ID.
     *
     * @param id - the ID of the SKU.
     * @return the SKU with the specified ID.
     */
    SKU getSKUById(Long id);
}
