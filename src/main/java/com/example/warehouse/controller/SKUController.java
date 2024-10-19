package com.example.warehouse.controller;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.service.SKUService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing SKUs.
 */
@RestController
@RequestMapping("/api/skus")
public class SKUController {

    private final SKUService skuService;

    public SKUController(SKUService skuService) {
        this.skuService = skuService;
    }

    @PostMapping
    public ResponseEntity<SKUDTO> createSKU(@RequestBody SKUDTO skuDto) {
        SKUDTO createdSku = skuService.createSKU(skuDto);
        return new ResponseEntity<>(createdSku, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SKUDTO> getSKUById(@PathVariable Long id) {
        SKUDTO skuDto = skuService.getSKUById(id);
        return ResponseEntity.ok(skuDto);
    }

    @GetMapping
    public ResponseEntity<List<SKUDTO>> getAllSKUs() {
        List<SKUDTO> skus = skuService.getAllSKUs();
        return ResponseEntity.ok(skus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SKUDTO> updateSKU(@PathVariable Long id, @RequestBody SKUDTO skuDto) {
        SKUDTO updatedSku = skuService.updateSKU(id, skuDto);
        return ResponseEntity.ok(updatedSku);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSKU(@PathVariable Long id) {
        skuService.deleteSKU(id);
        return ResponseEntity.noContent().build();
    }
}
