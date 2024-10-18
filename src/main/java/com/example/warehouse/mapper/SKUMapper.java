package com.example.warehouse.mapper;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.model.SKU;
import org.mapstruct.Mapper;

/**
 * Mapper for converting between SKU and SKUDTO.
 */
@Mapper(componentModel = "spring")
public interface SKUMapper {

    SKU toEntity(SKUDTO dto);

    SKUDTO toDto(SKU sku);
}
