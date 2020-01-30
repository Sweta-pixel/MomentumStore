package com.momentum.store.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momentum.store.domain.Customer;
import com.momentum.store.domain.Product;
import com.momentum.store.repo.CustomerRepository;
import com.momentum.store.repo.ProductRepository;
import com.momentum.store.service.MomentumService;

@Service
public class MomentumServiceImpl implements MomentumService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> getProducts(Integer id, List<String> productCodes) {

		return productRepository.findByIdOrCodeIn(id, productCodes);
	}

	@Override
	public String getPointsInfo(Integer customerId, Integer id, List<String> productCodes) {
		List<Product> products = getProducts(id, productCodes);
		
		Customer customer = getCustomer(customerId);
		int productPoints = 0;
		for (Product product : products) {
			productPoints = productPoints + product.getPointCost();
		}
		int val = customer.getActivePoints() - productPoints;

		if (val > 0)
			return "OK";
		else
			return "Not Eligibe";
	}

	@Override
	public boolean isProductCodesValid(List<String> productCodes) {
		List<Product> products = productRepository.findByCodeIn(productCodes);

		if (products == null || products.isEmpty() || products.size() == 0) {
			return false;
		} else
			return true;

	}

	@Override
	public Customer getCustomer(Integer customerId) {
		Optional<Customer> customerOpt = customerRepository.findById(customerId);

		return (customerOpt != null) ? customerOpt.get() : null;
	}

}
