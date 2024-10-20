package com.example.warehouse.controller;

import com.example.warehouse.service.ElasticsearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for searching products in Elasticsearch.
 */
@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final ElasticsearchService elasticsearchService;

    public SearchController(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;
    }

    @GetMapping
    public ResponseEntity<List<Object>> searchProducts(@RequestParam String query) {
        return ResponseEntity.ok(elasticsearchService.searchProducts(query));
    }
}
