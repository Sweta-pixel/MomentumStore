package com.momentum.store.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.momentum.store.domain.Customer;

public interface CustomerRepository extends MongoRepository<Customer, Integer> {

	List<Customer> findAll();
	
	Optional<Customer> findById(int id);
}
