package com.example.warehouse.service;

import com.example.warehouse.dto.SKUDTO;

import java.util.List;

/**
 * Service interface for managing SKUs.
 */
public interface SKUService {
    List<SKUDTO> getAllSKUs();
    SKUDTO getSKUById(Long skuId);
    SKUDTO createSKU(SKUDTO skuDTO);
}
