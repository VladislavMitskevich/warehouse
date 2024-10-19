package com.example.warehouse.service.impl;

import com.example.warehouse.dto.ProductDTO;
import com.example.warehouse.exception.ResourceNotFoundException;
import com.example.warehouse.mapper.ProductMapper;
import com.example.warehouse.model.Product;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.ProductSearchRepository;
import com.example.warehouse.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of the ProductService interface.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    private final ProductSearchRepository productSearchRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper,
                              ProductSearchRepository productSearchRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.productSearchRepository = productSearchRepository;
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDto) {
        Product product = productMapper.toEntity(productDto);
        Product savedProduct = productRepository.save(product);
        return productMapper.toDto(savedProduct);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        return productMapper.toDto(product);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO updateProduct(Long id, ProductDTO productDto) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));

        existingProduct.setName(productDto.getName());
        existingProduct.setDescription(productDto.getDescription());
        existingProduct.setPrice(productDto.getPrice());

        Product updatedProduct = productRepository.save(existingProduct);
        return productMapper.toDto(updatedProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id " + id));
        productRepository.delete(product);
    }

    @Override
    public List<ProductDTO> searchProductsByName(String name) {
        List<Product> products = productSearchRepository.findByNameContaining(name);
        return products.stream()
                .map(productMapper::toDto)
                .collect(Collectors.toList());
    }

}
