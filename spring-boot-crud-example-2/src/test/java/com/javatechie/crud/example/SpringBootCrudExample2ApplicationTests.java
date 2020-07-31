package com.javatechie.crud.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import com.javatechie.crud.example.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootCrudExample2ApplicationTests {

	@MockBean
	private ProductRepository repos;
	
	@Autowired
	private ProductService services;
	
	
	@Test
	public void getProductList() {
		when(repos.findAll()).thenReturn(Stream
				.of(new Product(101, "Pen", 5000, 20000), new Product(102, "Pencil", 5000, 20000)).collect(Collectors.toList()));
		assertEquals(2, services.getProducts().size());
	}
	
	@Test
	public void getUserbyAddressTest() {
		String name = "Pen";
		when(repos.findByName(name))
				.thenReturn((List<Product>) Stream.of(new Product(500, "Pen", 5, 300)).collect(Collectors.toList()));
		List<Product> userByName = services.getUserByName(name);
		assertEquals(userByName,services.getUserByName(name));
	}
	
	
	@Test
	public void saveProductTest() {
		Product user = new Product(101, "Pen", 5000, 20000);
		when(repos.save(user)).thenReturn(user);
		assertEquals(user,services.saveProduct(user) );
	}

	@Test
	public void deleteProductTest() {
		String deleteProduct = services.deleteProduct(101);
		assertEquals("product removed !! 101",deleteProduct);
	}
	
}
