package com.example.warehouse.mapper;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.model.SKU;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Mapper for converting between SKU and SKUDTO.
 */
@Mapper
public interface SKUMapper {
    SKUMapper INSTANCE = Mappers.getMapper(SKUMapper.class);

    SKUDTO toDTO(SKU sku);

    SKU toEntity(SKUDTO skuDTO);
}
