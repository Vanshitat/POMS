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

import com.purchaseOrder.entity.Customer;
import com.purchaseOrder.service.CustomerService;

@RestController
@RequestMapping("/Customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return ResponseEntity.ok(customerList);
    }
    
	@GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable int id) {
        return customerService.getCustomerById(id);
    }

	@PostMapping("/add")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
		Customer savedCustomer = customerService.saveCustomer(customer);
        return new ResponseEntity<Customer>(savedCustomer, HttpStatus.CREATED);
    }
	
	@PutMapping("/{id}")
    public Customer updateCustomer(@PathVariable int id, @RequestBody Customer customerRequest) {
       return customerService.updateCustomer(id, customerRequest);
    }
	
	@PatchMapping("/{id}")
	public Customer updateCustomerFields(@PathVariable int id, @RequestBody Map<String, Object> fields) {
		return customerService.updateCustomerByFields(id,fields);
	}
	
	@DeleteMapping("/{id}")
    public long deleteCustomer(@PathVariable int id) {
        return customerService.deleteCustomer(id);
    }

}
