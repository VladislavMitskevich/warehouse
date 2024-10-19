package com.example.warehouse.repository;

import com.example.warehouse.model.Product;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Elasticsearch repository for managing Product entities.
 */
@Repository
public class ProductSearchRepository {

    private final RestHighLevelClient elasticsearchClient;

    public ProductSearchRepository(RestHighLevelClient elasticsearchClient) {
        this.elasticsearchClient = elasticsearchClient;
    }

    /**
     * Finds products by name containing the specified keyword.
     *
     * @param name the keyword for searching.
     * @return a list of products with matching names.
     */
    public List<Product> findByNameContaining(String name) {
        SearchRequest searchRequest = new SearchRequest("products");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchQuery("name", name));
        searchRequest.source(searchSourceBuilder);

        try {
            SearchResponse searchResponse = elasticsearchClient.search(searchRequest, RequestOptions.DEFAULT);
            return processSearchResponse(searchResponse);
        } catch (IOException e) {
            throw new RuntimeException("Failed to search products in Elasticsearch", e);
        }
    }

    private List<Product> processSearchResponse(SearchResponse searchResponse) {
        List<Product> products = new ArrayList<>();
        for (SearchHit hit : searchResponse.getHits().getHits()) {
            Product product = new Product();
            product.setId(Long.parseLong(hit.getId()));
            product.setName((String) hit.getSourceAsMap().get("name"));
            product.setDescription((String) hit.getSourceAsMap().get("description"));
            product.setPrice(new BigDecimal((String) hit.getSourceAsMap().get("price")));
            products.add(product);
        }
        return products;
    }
}
