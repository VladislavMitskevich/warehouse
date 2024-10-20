package com.example.warehouse.mapper;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.model.SKU;
import org.mapstruct.Mapper;

/**
 * Mapper interface for converting SKU entity to SKUDTO and vice versa.
 */
@Mapper(componentModel = "spring")
public interface SKUMapper {
    SKUDTO toDTO(SKU sku);
    SKU toEntity(SKUDTO skuDTO);
}
