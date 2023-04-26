package com.purchaseOrder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.purchaseOrder.entity.Product;
import com.purchaseOrder.service.ProductService;

@RestController
@RequestMapping("/Product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value = "")
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productService.getAllProducts();
        return ResponseEntity.ok(productList);
    }
    
	@GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id);
    }

	@PostMapping("/add")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    	Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product productRequest) {
       return productService.updateProduct(id, productRequest);
    }
	
	@PatchMapping("/{id}")
	public Product updateProductFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return productService.updateProductByFields(id,fields);
	}
	
	@DeleteMapping("/{id}")
    public long deleteProduct(@PathVariable int id) {
        return productService.deleteProduct(id);
    }
}
