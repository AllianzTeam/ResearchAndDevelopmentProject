package com.groupchallenge.co2tracker.repository;

import com.groupchallenge.co2tracker.model.CO2Data;
import org.springframework.data.repository.CrudRepository;

public interface Co2Repository extends CrudRepository<CO2Data, Integer> {

}
