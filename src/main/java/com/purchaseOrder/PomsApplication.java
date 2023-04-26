package com.purchaseOrder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class PomsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PomsApplication.class, args);
	}

}
