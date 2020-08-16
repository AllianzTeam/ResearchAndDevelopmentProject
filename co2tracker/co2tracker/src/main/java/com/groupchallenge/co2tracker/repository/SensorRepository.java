package com.groupchallenge.co2tracker.repository;

import com.groupchallenge.co2tracker.model.Sensor;
import org.springframework.data.repository.CrudRepository;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {

}
