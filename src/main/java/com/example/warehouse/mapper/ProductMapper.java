package com.example.warehouse.mapper;

import com.example.warehouse.dto.ProductDTO;
import com.example.warehouse.model.Product;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between Product entity and ProductDTO.
 */
@Component
public class ProductMapper {

    public Product toEntity(ProductDTO productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        return product;
    }

    public ProductDTO toDto(Product product) {
        ProductDTO productDto = new ProductDTO();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        return productDto;
    }
}
