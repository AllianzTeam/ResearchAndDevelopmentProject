package com.groupchallenge.co2tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupchallenge.co2tracker.model.Customer;
import com.groupchallenge.co2tracker.repository.CustomerRepository;

@Service  
public class CustomerService {
	
	@Autowired  
	CustomerRepository customerRepository; 
	
	public Customer getCustomerById(int id)   {  
		
		return customerRepository.findById(id).get();  
	}  
	
	public void saveOrUpdate(Customer customer)   {  
		
		customerRepository.save(customer);  
	}  

}
