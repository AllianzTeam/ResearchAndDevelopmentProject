package com.groupchallenge.co2tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupchallenge.co2tracker.model.Customer;
import com.groupchallenge.co2tracker.service.CustomerService;

@RestController  
public class CustomerController {
	
	@Autowired  
	CustomerService customerService;  
	
	@GetMapping("/customer/{id}")
	private Customer getStudent(@PathVariable("id") int id)   
	{  
		return customerService.getCustomerById(id);  
	}  
	
	@PostMapping("/customer")
	private int saveCustomer(@RequestBody Customer customer)   
	{  
		customerService.saveOrUpdate(customer);  
		return customer.getId();  
	}  

}
