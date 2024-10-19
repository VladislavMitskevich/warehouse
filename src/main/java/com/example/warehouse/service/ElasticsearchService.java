package com.example.warehouse.service;

import java.io.IOException;

/**
 * Interface for Elasticsearch service to handle data loading operations.
 */
public interface ElasticsearchService {

    /**
     * Loads data from the database to Elasticsearch.
     *
     * @throws IOException if there is an error during the data loading process.
     */
    void loadDataToElasticsearch() throws IOException;
}
