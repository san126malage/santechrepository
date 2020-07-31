package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
	List<Product> findByName(String name);
}

