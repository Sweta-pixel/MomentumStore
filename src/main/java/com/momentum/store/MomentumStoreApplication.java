package com.momentum.store;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
//import org.springframework.metrics.export.prometheus.EnablePrometheusMetrics;

import com.momentum.store.domain.Customer;
import com.momentum.store.domain.Product;
import com.momentum.store.repo.CustomerRepository;
import com.momentum.store.repo.ProductRepository;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
//@EnablePrometheusMetrics
public class MomentumStoreApplication implements CommandLineRunner  {

	//@Autowired private PersonRepository personRepository;
	
	@Autowired private CustomerRepository customerRepository;
	
	@Autowired private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(MomentumStoreApplication.class, args);
	}
	
	@Override
	  public void run(String... strings) throws Exception {
		customerRepository.deleteAll();
		productRepository.deleteAll();
		final Customer customer1 = new Customer(1, "Tom",10000);
		final Customer customer2 = new Customer(2, "John",500);
		final Customer customer3 = new Customer(3, "Jerry",5000);
		final Customer customer4 = new Customer(4, "Terry",300);
		final Customer customer5 = new Customer(5, "Doe",150000);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);
		customerList.add(customer5);
		customerRepository.saveAll(customerList);
		
		final Product product1 = new Product(1,"Mobile", "001M", 100);
		final Product product2 = new Product(2,"Laptop", "002L", 200);
		final Product product3 = new Product(3,"Speaker", "001SP", 105);
		final Product product4 = new Product(4,"Vaccum Cleaner", "V09M", 190);
		final Product product5 = new Product(5,"Television", "11AT", 9000);
		final Product product6 = new Product(6,"Washing Machine", "40WM", 5000);
		final Product product7 = new Product(7,"Refrigerator", "R01M", 1000);
		
		List<Product> productList = new ArrayList<>();
		productList.add(product1);
		productList.add(product2);
		productList.add(product3);
		productList.add(product4);
		productList.add(product5);
		productList.add(product6);
		productList.add(product7);
		productRepository.saveAll(productList);
		
		System.out.println("All Customer");
		customerRepository.findAll().forEach(System.out::println);
		
		System.out.println("All product");
		productRepository.findAll().forEach(System.out::println);
	}
}
