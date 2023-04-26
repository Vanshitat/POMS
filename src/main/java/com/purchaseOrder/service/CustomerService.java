package com.purchaseOrder.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import com.purchaseOrder.entity.Customer;
import com.purchaseOrder.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	public List<Customer> getAllCustomers() {
        return this.customerRepository.findAll();
    }
    
    public Customer getCustomerById(int id) {
        return customerRepository.findById(id).get();
    }
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	public Integer isCustomerPresent(Customer customer) {
		Customer customer1 = customerRepository.getCustomerByEmailAndName(customer.getEmail(),customer.getName());
        return customer1!=null ? customer1.getId(): null ;
	}
	
	public Customer updateCustomer(int id, Customer customerRequest) {
		Customer existingCustomer = customerRepository.findById(id).get(); 
        existingCustomer.setName(customerRequest.getName());
        existingCustomer.setEmail(customerRequest.getEmail());
        existingCustomer.setGender(customerRequest.getGender());
        existingCustomer.setAge(customerRequest.getAge());
        existingCustomer.setCity(customerRequest.getCity());
        return customerRepository.save(existingCustomer);
    }
    
    public Customer updateCustomerByFields(int id, Map<String, Object> fields) {
        Optional<Customer> existingCustomer = customerRepository.findById(id);

        if (existingCustomer.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findRequiredField(Customer.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingCustomer.get(), value);
            });
            return customerRepository.saveAndFlush(existingCustomer.get());
        }
        return null;
    }
    
    public long deleteCustomer(int id) {
    	customerRepository.deleteById(id);
        return customerRepository.count();
    }
}
