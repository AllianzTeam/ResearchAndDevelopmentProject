package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.Customer;
import com.groupchallenge.co2tracker.model.Sensor;
import com.groupchallenge.co2tracker.repository.SensorRepository;

import java.util.List;

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
	
	public List <Sensor> getAllSensorValues(){
		
		List <Sensor> l1= (List <Sensor>) sensorRepository.findAll();
		l1.forEach(l->System.out.println(l));
		return (List <Sensor>) sensorRepository.findAll();
	}
}
