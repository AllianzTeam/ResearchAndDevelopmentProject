package com.groupchallenge.co2tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.groupchallenge.co2tracker.model.Customer;
import com.groupchallenge.co2tracker.service.CustomerService;

@RestController
@RequestMapping("api/customer")
public class CustomerController {
	
	@Autowired  
	CustomerService customerService;  
	
	@GetMapping("/{id}")
	private Customer getCustomer(@PathVariable("id") int id)
	{  
		return customerService.getCustomerById(id);  
	}  
	
	@PostMapping("/")
	private int saveCustomer(@RequestBody Customer customer)   
	{  
		System.out.println("Inside CustomerSave");
		customerService.saveOrUpdate(customer);  
		return customer.getId();  
	}  

}
