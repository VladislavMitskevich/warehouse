package com.example.warehouse.service.impl;

import com.example.warehouse.model.SKU;
import com.example.warehouse.repository.SKURepository;
import com.example.warehouse.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing SKUs.
 */
@Service
public class SKUServiceImpl implements SKUService {

    private final SKURepository skuRepository;

    @Autowired
    public SKUServiceImpl(SKURepository skuRepository) {
        this.skuRepository = skuRepository;
    }

    @Override
    public List<SKU> getAllAvailableSKUs() {
        return skuRepository.findByAvailable(true);
    }

    @Override
    public SKU saveSKU(SKU sku) {
        return skuRepository.save(sku);
    }

    @Override
    public SKU getSKUById(Long id) {
        Optional<SKU> sku = skuRepository.findById(id);
        return sku.orElse(null);
    }
}
