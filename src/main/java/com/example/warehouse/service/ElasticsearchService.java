package com.example.warehouse.service;

import java.util.List;

/**
 * Service interface for interacting with Elasticsearch.
 */
public interface ElasticsearchService {
    List<Object> searchProducts(String query);
    void loadDataToElasticsearch();
}
