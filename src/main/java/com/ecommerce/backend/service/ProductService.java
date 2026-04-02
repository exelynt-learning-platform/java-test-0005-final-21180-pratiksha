package com.ecommerce.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.backend.entity.Product;
import com.ecommerce.backend.repository.ProductRepository;

@Service
public class ProductService {
	  @Autowired
	    private ProductRepository productRepository;

	    public Product save(Product product) {
	        return productRepository.save(product);
	    }

	    public List<Product> getAll() {
	        return productRepository.findAll();
	    }
	}


