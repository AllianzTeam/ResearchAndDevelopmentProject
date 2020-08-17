package com.groupchallenge.co2tracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupchallenge.co2tracker.model.Customer;
import com.groupchallenge.co2tracker.model.Sensor;
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

	public List <Customer> getAllCustomers(){
		List <Customer> l1= (List <Customer>) customerRepository.findAll();
		l1.forEach(l->System.out.println(l));
		return (List <Customer>) customerRepository.findAll();
	}
	
	
}
