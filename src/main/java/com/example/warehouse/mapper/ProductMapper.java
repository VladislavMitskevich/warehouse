package com.example.warehouse.mapper;

import com.example.warehouse.dto.ProductDTO;
import com.example.warehouse.model.Product;
import org.mapstruct.Mapper;

/**
 * Mapper for converting between Product and ProductDTO.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDTO dto);

    ProductDTO toDto(Product product);
}
