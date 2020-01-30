package com.momentum.store.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.momentum.store.domain.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
	List<Product> findAll();
	
	List<Product> findByIdOrCodeIn(final int id, final List<String> codes);

	List<Product> findByCodeIn(List<String> productCodes);
}
