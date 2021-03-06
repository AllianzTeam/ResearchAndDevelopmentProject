package com.groupchallenge.co2tracker.controller;

import com.groupchallenge.co2tracker.model.Sensor;
import com.groupchallenge.co2tracker.repository.SensorRepository;
import com.groupchallenge.co2tracker.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/sensor")
public class SensorController {
	@Autowired SensorService sensorService;

	@Autowired SensorRepository sensorRepository;

	@GetMapping("/{id}")
	private Sensor getSensor(@PathVariable("id") int id)
	{
		return sensorService.getSensorById(id);
	}

	/*Method to post Sensor details*/
	@PostMapping("/")
	private int saveSensor(@RequestBody Sensor sensor)
	{
		sensorService.saveOrUpdate(sensor);
		return sensor.getId();
	}

	@GetMapping("/sensors")
	public List getAllSensorValues() {
		return  (List)sensorRepository.findAll();
	}

}
