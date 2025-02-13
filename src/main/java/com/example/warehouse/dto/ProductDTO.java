package com.example.warehouse.dto;

import java.util.List;

/**
 * Data Transfer Object for Product.
 */
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private boolean active;
    private List<SKUDTO> skus;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<SKUDTO> getSkus() {
        return skus;
    }

    public void setSkus(List<SKUDTO> skus) {
        this.skus = skus;
    }
}
