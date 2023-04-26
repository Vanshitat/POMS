package com.purchaseOrder.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import com.purchaseOrder.entity.Product;
import com.purchaseOrder.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	 private ProductRepository productRepository;

	    public ProductService(ProductRepository productRepository) {
	        this.productRepository = productRepository;
	    }
	    
	    public List<Product> getAllProducts() {
	        return this.productRepository.findAll();
	    }
	    
	    public Product getProductById(int id) {
	        return productRepository.findById(id).get();
	    }
	    
	    public Product saveProduct(Product product) {
	        return productRepository.save(product);
	    }
	    
	    public Product updateProduct(int id, Product productRequest) {
	        // get the product from DB by id
	        // update with new value getting from request
	        Product existingProduct = productRepository.findById(id).get(); // DB
	        existingProduct.setName(productRequest.getName());
	        existingProduct.setAvailableQuantity(productRequest.getAvailableQuantity());
	        existingProduct.setPrice(productRequest.getPrice());
	        return productRepository.save(existingProduct);
	    }
	    
	    public Product updateProductByFields(int id, Map<String, Object> fields) {
	        Optional<Product> existingProduct = productRepository.findById(id);

	        if (existingProduct.isPresent()) {
	            fields.forEach((key, value) -> {
	                Field field = ReflectionUtils.findRequiredField(Product.class, key);
	                field.setAccessible(true);
	                ReflectionUtils.setField(field, existingProduct.get(), value);
	            });
	            return productRepository.saveAndFlush(existingProduct.get());
	        }
	        return null;
	    }
	    
	    public long deleteProduct(int id) {
	    	productRepository.deleteById(id);
	        return productRepository.count();
	    }
}
