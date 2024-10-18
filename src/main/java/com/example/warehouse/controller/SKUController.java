package com.example.warehouse.controller;

import com.example.warehouse.model.SKU;
import com.example.warehouse.service.SKUService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public SKUController(SKUService skuService) {
        this.skuService = skuService;
    }

    /**
     * Retrieves all available SKUs.
     *
     * @return a list of available SKUs.
     */
    @GetMapping
    public ResponseEntity<List<SKU>> getAllAvailableSKUs() {
        List<SKU> skus = skuService.getAllAvailableSKUs();
        return new ResponseEntity<>(skus, HttpStatus.OK);
    }

    /**
     * Retrieves an SKU by its ID.
     *
     * @param id - the ID of the SKU.
     * @return the SKU with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<SKU> getSKUById(@PathVariable Long id) {
        SKU sku = skuService.getSKUById(id);
        if (sku != null) {
            return new ResponseEntity<>(sku, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Creates a new SKU.
     *
     * @param sku - the SKU to create.
     * @return the created SKU.
     */
    @PostMapping
    public ResponseEntity<SKU> createSKU(@RequestBody SKU sku) {
        SKU savedSKU = skuService.saveSKU(sku);
        return new ResponseEntity<>(savedSKU, HttpStatus.CREATED);
    }

    /**
     * Updates an existing SKU.
     *
     * @param id - the ID of the SKU to update.
     * @param sku - the updated SKU details.
     * @return the updated SKU.
     */
    @PutMapping("/{id}")
    public ResponseEntity<SKU> updateSKU(@PathVariable Long id, @RequestBody SKU sku) {
        sku.setId(id);
        SKU updatedSKU = skuService.saveSKU(sku);
        return new ResponseEntity<>(updatedSKU, HttpStatus.OK);
    }
}
