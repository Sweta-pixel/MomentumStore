package com.momentum.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.metrics.annotation.Timed;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.momentum.store.domain.Product;
import com.momentum.store.exception.CustomerNotFoundException;
import com.momentum.store.exception.InsufficientPointException;
import com.momentum.store.exception.NoProductProvidedException;
import com.momentum.store.exception.ProductCodeNotfoundException;
import com.momentum.store.service.MomentumService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

@RestController
@CrossOrigin
//@Timed
@RequestMapping("/momentum/v1")
public class MomentumController {

	@Autowired
	MomentumService momentumService;

	@ApiOperation(value = "Get list of all available products", response = Product.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "successfully retrieved products list")
	@GetMapping("/getAllProducts")
	public List<Product> getAllProductDetails() {
		return momentumService.getAllProducts();
	}

	@ApiOperation(value = "Get List of products of given product id or list of product codes", response = Product.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "successfully retrieved products list")
	@GetMapping("/getProducts")
	public List<Product> getProductDetails(@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "productCodes", required = false) List<String> productCodes) {

		return momentumService.getProducts(id, productCodes);
	}

	@ApiOperation(value = "If customer has enough point to make the purchase of the list of products", response = String.class, responseContainer = "List")
	@ApiResponse(code = 200, message = "successfully retrieved info if customer can purchase or not")
	@GetMapping("/getPointsInfo")
	public ResponseEntity<String> getPointsInfo(
			@RequestParam(value = "customerId", required = false) Integer customerId,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "productCodes", required = false) List<String> productCodes) {

		if (id == null && productCodes == null) {
			throw new NoProductProvidedException();
		}

		if (!momentumService.isProductCodesValid(productCodes)) {
			throw new ProductCodeNotfoundException();
		}

		if (momentumService.getCustomer(customerId) == null) {
			throw new CustomerNotFoundException();
		}

		String ifEligibe = momentumService.getPointsInfo(customerId, id, productCodes);

		if ("OK".equalsIgnoreCase(ifEligibe)) {
			return new ResponseEntity<>(ifEligibe, HttpStatus.OK);
		} else {
			throw new InsufficientPointException();
		}
	}
}
