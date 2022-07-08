package com.example.product;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/rest/products")

public class AppController {
	@Autowired
	private ProductService productService;
	
	Logger logger = LoggerFactory.getLogger(AppController.class);
	@GetMapping
	public List<Product> getAllProduct(){
		return productService.getAllProducts();
	}	
	@GetMapping("/products/{id}")
	private Product getProductbyId(@PathVariable("id") long id) {
		return productService.getProductbyId(id); 
	}
	@PostMapping("/addproduct")
	public long createProduct(@RequestBody Product product) {
		
		productService.SaveorUpdate(product);
		return product.getId();
		
	}
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product){
		productService.Update(product);
		return product;
				
	}
	@DeleteMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") Long id){
		productService.delete(id);
	}
}
