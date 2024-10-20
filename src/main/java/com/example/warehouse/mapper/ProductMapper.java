package com.example.warehouse.mapper;

import com.example.warehouse.dto.ProductDTO;
import com.example.warehouse.model.Product;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting Product entity to ProductDTO and vice versa.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    Product toEntity(ProductDTO productDTO);
}
