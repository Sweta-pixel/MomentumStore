package com.momentum.store;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.momentum.store.domain.Customer;
import com.momentum.store.domain.Product;
import com.momentum.store.service.MomentumService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MomentumServiceImplTest {

	@Autowired
	MomentumService momentumService;

	@Test
	public void checkAllProducts() {
		List<Product> products = momentumService.getAllProducts();
		assertNotNull(products);
		assertEquals(products.size(), 7);

	}

	@Test
	public void checkProductByIdOrCodes() {
		List<Product> productById = momentumService.getProducts(1, null);
		List<Product> productByCodeAndId = momentumService.getProducts(1, Arrays.asList("001M"));
		List<Product> productsByCode = momentumService.getProducts(null, Arrays.asList("001M", "002L", "001SP"));
		List<Product> noProduct = momentumService.getProducts(10, null);

		assertNotNull(productById);
		assertNotNull(productByCodeAndId);
		assertNotNull(productsByCode);
		assertNull(noProduct);

		assertEquals(productById.size(), 1);
		// assertEquals(productByCodeAndId.size(),1);
		assertEquals(productsByCode.size(), 3);

	}

	@Test
	public void isProductCodesValid() {
		boolean products = momentumService.isProductCodesValid(Arrays.asList("001M", "002L", "001SP"));
		
		assertTrue(products);

	}
	
	@Test
	public void getCustomer() {
		Customer customer = momentumService.getCustomer(2);
		Customer noCustomer = momentumService.getCustomer(10);
		assertNotNull(customer);
		assertNull(noCustomer);
	}
	

}
