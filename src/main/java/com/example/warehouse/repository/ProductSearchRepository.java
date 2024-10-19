package com.example.warehouse.repository;

import com.example.warehouse.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Elasticsearch repository for managing Product entities.
 */
@Repository
public interface ProductSearchRepository extends ElasticsearchRepository<Product, Long> {

    /**
     * Finds products by name containing the specified keyword.
     *
     * @param name the keyword for searching.
     * @return a list of products with matching names.
     */
    List<Product> findByNameContaining(String name);
}
