package com.example.warehouse.service;

import com.example.warehouse.dto.SKUDTO;
import java.util.List;

/**
 * Interface for SKU service to handle SKU-related operations.
 */
public interface SKUService {

    /**
     * Creates a new SKU.
     *
     * @param skuDto the SKU data transfer object.
     * @return the created SKU as a DTO.
     */
    SKUDTO createSKU(SKUDTO skuDto);

    /**
     * Retrieves an SKU by its ID.
     *
     * @param id the ID of the SKU.
     * @return the corresponding SKU DTO.
     */
    SKUDTO getSKUById(Long id);

    /**
     * Retrieves all SKUs.
     *
     * @return a list of all SKU DTOs.
     */
    List<SKUDTO> getAllSKUs();

    /**
     * Updates an existing SKU.
     *
     * @param id the ID of the SKU to update.
     * @param skuDto the updated SKU data transfer object.
     * @return the updated SKU as a DTO.
     */
    SKUDTO updateSKU(Long id, SKUDTO skuDto);

    /**
     * Deletes an SKU by its ID.
     *
     * @param id the ID of the SKU to delete.
     */
    void deleteSKU(Long id);
}
