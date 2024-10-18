package com.example.elasticsearch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "skus")
public class SKU {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String skuCode;

    private String color;

    @Column(nullable = false)
    private boolean availability;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Constructors, getters, and setters
    public SKU() {}

    public SKU(String skuCode, String color, boolean availability, Product product) {
        this.skuCode = skuCode;
        this.color = color;
        this.availability = availability;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
