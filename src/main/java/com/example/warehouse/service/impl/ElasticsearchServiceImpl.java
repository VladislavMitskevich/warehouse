package com.example.warehouse.service.impl;

import com.example.warehouse.mapper.ProductMapper;
import com.example.warehouse.mapper.SKUMapper;
import com.example.warehouse.model.Product;
import com.example.warehouse.model.SKU;
import com.example.warehouse.repository.ProductRepository;
import com.example.warehouse.repository.SKURepository;
import com.example.warehouse.service.ElasticsearchService;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Implementation of the ElasticsearchService interface.
 */
@Service
public class ElasticsearchServiceImpl implements ElasticsearchService {

    private final RestHighLevelClient elasticsearchClient;
    private final ProductRepository productRepository;
    private final SKURepository skuRepository;
    private final ProductMapper productMapper;
    private final SKUMapper skuMapper;

    public ElasticsearchServiceImpl(RestHighLevelClient elasticsearchClient, ProductRepository productRepository, SKURepository skuRepository, ProductMapper productMapper, SKUMapper skuMapper) {
        this.elasticsearchClient = elasticsearchClient;
        this.productRepository = productRepository;
        this.skuRepository = skuRepository;
        this.productMapper = productMapper;
        this.skuMapper = skuMapper;
    }

    @Override
    public void loadDataToElasticsearch() throws IOException {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            IndexRequest indexRequest = new IndexRequest("products")
                    .id(product.getId().toString())
                    .source(productMapper.toDto(product), XContentType.JSON);
            IndexResponse indexResponse = elasticsearchClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("Indexed product with ID: " + indexResponse.getId());
        }

        List<SKU> skus = skuRepository.findAll();
        for (SKU sku : skus) {
            IndexRequest indexRequest = new IndexRequest("skus")
                    .id(sku.getId().toString())
                    .source(skuMapper.toDto(sku), XContentType.JSON);
            IndexResponse indexResponse = elasticsearchClient.index(indexRequest, RequestOptions.DEFAULT);
            System.out.println("Indexed SKU with ID: " + indexResponse.getId());
        }
    }
}
