package com.example.warehouse.controller;

import com.example.warehouse.dto.SKUDTO;
import com.example.warehouse.service.SKUService;
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

    @GetMapping
    public ResponseEntity<List<SKUDTO>> getAllSKUs() {
        return ResponseEntity.ok(skuService.getAllSKUs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SKUDTO> getSKUById(@PathVariable Long id) {
        return ResponseEntity.ok(skuService.getSKUById(id));
    }

    @PostMapping
    public ResponseEntity<SKUDTO> createSKU(@RequestBody SKUDTO skuDTO) {
        return ResponseEntity.ok(skuService.createSKU(skuDTO));
    }
}
