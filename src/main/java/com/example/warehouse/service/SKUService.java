package com.example.warehouse.service;

import com.example.warehouse.dto.SKUDTO;
import java.util.List;

/**
 * Service interface for managing SKUs.
 */
public interface SKUService {

    /**
     * Creates a new SKU.
     *
     * @param skuDto the SKU data transfer object.
     * @return the created SKU as a DTO.
     */
    SKUDTO createSku(SKUDTO skuDto);

    /**
     * Retrieves an SKU by its ID.
     *
     * @param id the ID of the SKU.
     * @return the SKU as a DTO.
     */
    SKUDTO getSkuById(Long id);

    /**
     * Retrieves all SKUs.
     *
     * @return a list of SKU DTOs.
     */
    List<SKUDTO> getAllSkus();

    /**
     * Updates an existing SKU.
     *
     * @param id the ID of the SKU to update.
     * @param skuDto the updated SKU data transfer object.
     * @return the updated SKU as a DTO.
     */
    SKUDTO updateSku(Long id, SKUDTO skuDto);

    /**
     * Deletes an SKU by its ID.
     *
     * @param id the ID of the SKU to delete.
     */
    void deleteSku(Long id);
}
