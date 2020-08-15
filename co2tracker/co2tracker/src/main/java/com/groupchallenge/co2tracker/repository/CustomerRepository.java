package com.groupchallenge.co2tracker.repository;

import org.springframework.data.repository.CrudRepository;

import com.groupchallenge.co2tracker.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
