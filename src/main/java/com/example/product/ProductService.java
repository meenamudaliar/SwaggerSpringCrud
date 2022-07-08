package com.example.product;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Service
@CacheConfig(cacheNames="productinfo")
public class ProductService {
@Autowired
ProductRepository productRepository;
private static final Logger logger=LoggerFactory.getLogger(ProductService.class);

	public List<Product> getAllProducts() {
		
	return (List<Product>) productRepository.findAll();
	}
@Cacheable(value="productinfo",key="#id")
	public Product getProductbyId(long id) {
	logger.info("fetching product from db");
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	public void SaveorUpdate(Product product) {
		// TODO Auto-generated method stub
		productRepository.save(product);
	}
	
	public void delete(Long id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}
@CachePut(value="productinfo",key="#product.id")
	public Product Update(Product product) {
	logger.info("product updated with new name");
		// TODO Auto-generated method stub
		Product p=productRepository.findById(product.getId()).orElse(null);
		p.setName(product.getName());
		p.setBrand(product.getBrand());
		p.setMadein(product.getMadein());
		p.setPrice(product.getPrice());
		return productRepository.save(p);
	}
	

}
