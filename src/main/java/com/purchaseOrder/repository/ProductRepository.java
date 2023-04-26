package com.purchaseOrder.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.purchaseOrder.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	
}
