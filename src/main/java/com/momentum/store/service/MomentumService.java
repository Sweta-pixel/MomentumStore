package com.momentum.store.service;

import java.util.List;

import com.momentum.store.domain.Customer;
import com.momentum.store.domain.Product;

public interface MomentumService {

	List<Product> getAllProducts();
	
	List<Product> getProducts(Integer id,List<String> productCodes);
	
	String getPointsInfo(Integer customerId,Integer id,List<String> productCodes);

	boolean isProductCodesValid(List<String> productCodes);

	Customer getCustomer(Integer customerId);
}
