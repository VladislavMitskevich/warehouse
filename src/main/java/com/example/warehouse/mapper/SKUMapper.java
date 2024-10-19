package com.example.warehouse.mapper;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.model.SKU;
import org.springframework.stereotype.Component;

/**
 * Mapper for converting between SKU entity and SKUDTO.
 */
@Component
public class SKUMapper {

    public SKU toEntity(SKUDTO skuDto) {
        SKU sku = new SKU();
        sku.setId(skuDto.getId());
        sku.setPrice(skuDto.getPrice());
        sku.setStockQuantity(skuDto.getStockQuantity());
        return sku;
    }

    public SKUDTO toDto(SKU sku) {
        SKUDTO skuDto = new SKUDTO();
        skuDto.setId(sku.getId());
        skuDto.setProductId(sku.getProduct().getId());
        skuDto.setPrice(sku.getPrice());
        skuDto.setStockQuantity(sku.getStockQuantity());
        return skuDto;
    }
}

