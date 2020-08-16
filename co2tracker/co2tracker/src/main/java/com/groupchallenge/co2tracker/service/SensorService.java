package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.Sensor;
import com.groupchallenge.co2tracker.repository.SensorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
	@Autowired SensorRepository sensorRepository;

	public Sensor getSensorById(int id)   {

		return sensorRepository.findById(id).get();
	}

	public void saveOrUpdate(Sensor sensor)   {

		sensorRepository.save(sensor);
	}
}
