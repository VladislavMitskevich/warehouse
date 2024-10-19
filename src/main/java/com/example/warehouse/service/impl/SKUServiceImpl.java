package com.example.warehouse.service.impl;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.exception.ResourceNotFoundException;
import com.example.warehouse.mapper.SKUMapper;
import com.example.warehouse.model.Product;
import com.example.warehouse.model.SKU;
import com.example.warehouse.repository.SKURepository;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.service.SKUService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the SKUService interface.
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
    public SKUDTO createSKU(SKUDTO skuDto) {
        SKU sku = skuMapper.toEntity(skuDto);
        Product product = productRepository.findById(skuDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + skuDto.getProductId()));
        sku.setProduct(product);
        SKU savedSKU = skuRepository.save(sku);
        return skuMapper.toDto(savedSKU);
    }

    @Override
    public SKUDTO getSKUById(Long id) {
        SKU sku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SKU not found with id " + id));
        return skuMapper.toDto(sku);
    }

    @Override
    public List<SKUDTO> getAllSKUs() {
        return skuRepository.findAll().stream()
                .map(skuMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public SKUDTO updateSKU(Long id, SKUDTO skuDto) {
        SKU existingSKU = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SKU not found with id " + id));

        existingSKU.setPrice(skuDto.getPrice());
        existingSKU.setStockQuantity(skuDto.getStockQuantity());

        Product product = productRepository.findById(skuDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + skuDto.getProductId()));
        existingSKU.setProduct(product);

        SKU updatedSKU = skuRepository.save(existingSKU);
        return skuMapper.toDto(updatedSKU);
    }

    @Override
    public void deleteSKU(Long id) {
        SKU sku = skuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SKU not found with id " + id));
        skuRepository.delete(sku);
    }
}
