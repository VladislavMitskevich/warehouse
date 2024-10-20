package com.example.warehouse.service.impl;

import com.example.warehouse.model.Product;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.service.ElasticsearchService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for managing interactions with Elasticsearch.
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {
    private final RestHighLevelClient client;
    private final ProductRepository productRepository;

    public ElasticsearchServiceImpl(RestHighLevelClient client, ProductRepository productRepository) {
        this.client = client;
        this.productRepository = productRepository;
    }

    @Override
    public List<Object> searchProducts(String query) {
        try {
            SearchRequest searchRequest = new SearchRequest("products");
            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.query(QueryBuilders.multiMatchQuery(query, "name", "description", "skus.name"));
            searchRequest.source(sourceBuilder);

            SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
            return List.of(searchResponse.getHits().getHits())
                    .stream()
                    .map(hit -> hit.getSourceAsMap())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("Error executing search", e);
        }
    }

    @Override
    public void loadDataToElasticsearch() {
        // Implementation to load data from database to Elasticsearch.
    }
}
