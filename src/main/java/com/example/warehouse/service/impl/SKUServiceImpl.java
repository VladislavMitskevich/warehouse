package com.example.warehouse.service.impl;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.exception.ResourceNotFoundException;
import com.example.warehouse.mapper.SKUMapper;
import com.example.warehouse.model.Product;
import com.example.warehouse.model.SKU;
import com.example.warehouse.repository.ProductRepository;
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
    private final ProductRepository productRepository;
    private final SKUMapper skuMapper;

    public SKUServiceImpl(SKURepository skuRepository, ProductRepository productRepository, SKUMapper skuMapper) {
        this.skuRepository = skuRepository;
        this.productRepository = productRepository;
        this.skuMapper = skuMapper;
    }

    @Override
    public SKUDTO createSku(SKUDTO skuDto) {
        Product product = productRepository.findById(skuDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + skuDto.getProductId() + " not found"));

        SKU sku = skuMapper.toEntity(skuDto);
        sku.setProduct(product);

        SKU savedSku = skuRepository.save(sku);
        return skuMapper.toDto(savedSku);
    }

    @Override
    public SKUDTO getSkuById(Long id) {
        return skuRepository.findById(id)
                .map(skuMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("SKU with ID " + id + " not found"));
    }

    @Override
    public List<SKUDTO> getAllSkus() {
        return skuRepository.findAll().stream()
                .map(skuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SKUDTO updateSku(Long id, SKUDTO skuDto) {
        SKU existingSku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SKU with ID " + id + " not found"));

        Product product = productRepository.findById(skuDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product with ID " + skuDto.getProductId() + " not found"));

        // Обновляем поля SKU
        existingSku.setProduct(product);
        existingSku.setPrice(skuDto.getPrice());
        existingSku.setStockQuantity(skuDto.getStockQuantity());

        SKU updatedSku = skuRepository.save(existingSku);
        return skuMapper.toDto(updatedSku);
    }

    @Override
    public void deleteSku(Long id) {
        SKU existingSku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SKU with ID " + id + " not found"));

        skuRepository.delete(existingSku);
    }
}
