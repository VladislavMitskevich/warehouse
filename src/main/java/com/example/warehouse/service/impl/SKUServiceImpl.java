package com.example.warehouse.service.impl;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.mapper.SKUMapper;
import com.example.warehouse.model.SKU;
import com.example.warehouse.repository.SKURepository;
import com.example.warehouse.service.SKUService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing SKUs.
 */
@Service
public class SKUServiceImpl implements SKUService {
    private final SKURepository skuRepository;
    private final SKUMapper skuMapper;

    public SKUServiceImpl(SKURepository skuRepository, SKUMapper skuMapper) {
        this.skuRepository = skuRepository;
        this.skuMapper = skuMapper;
    }

    @Override
    public List<SKUDTO> getAllSKUs() {
        return skuRepository.findAll()
                .stream()
                .map(skuMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SKUDTO getSKUById(Long skuId) {
        SKU sku = skuRepository.findById(skuId)
                .orElseThrow(() -> new RuntimeException("SKU not found"));
        return skuMapper.toDTO(sku);
    }

    @Override
    public SKUDTO createSKU(SKUDTO skuDTO) {
        SKU sku = skuMapper.toEntity(skuDTO);
        return skuMapper.toDTO(skuRepository.save(sku));
    }
}
