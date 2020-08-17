package com.groupchallenge.co2tracker.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.groupchallenge.co2tracker.model.CO2Data;
import com.groupchallenge.co2tracker.model.Sensor;
import com.groupchallenge.co2tracker.repository.Co2Repository;
import com.groupchallenge.co2tracker.service.Co2Service;
import com.groupchallenge.co2tracker.service.SensorService;

@RestController
@RequestMapping("api/co2tracker")
public class Co2Controller {
	@Autowired Co2Service co2Service;
	@Autowired Co2Repository co2Repository;
	@Autowired SensorService sensorService;

	@GetMapping("/{id}")
	private CO2Data getCo2(@PathVariable("id") int id)
	{
		return co2Service.getCo2ById(id);
	}

	@PostMapping("/")
	private int saveCo2(@RequestBody CO2Data co2)
	{
		co2Service.saveOrUpdate(co2);
		return co2.getId();
	}

	@GetMapping("/co2Values")
	public List getAllC02Values() {
		return  (List)co2Repository.findAll();
	}
	
	@GetMapping("/co2ValuesBySensorId")
	public List getAllC02ValuesBySesorId() {
		return  (List)co2Repository.findAll();
	}
	
	/*This method is calculate average value of CO2 reading from multiple sensor
	 * Expected input - City ID and date
	 * Expected Output Average CO2 vlaue*/
	@GetMapping("/co2AggregateValues/{id}")
	public double getAggregateCo2Values(@PathVariable("id") int i, @RequestParam("date")@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate  date ) {
		List<Sensor> allSensorValues = sensorService.getAllSensorValues();
		List<Sensor> sesnsorlist = allSensorValues.stream().filter(s->s.getDistrict().getId().equals(i)).collect(Collectors.toList());
		List<Integer> sensorid = new ArrayList<Integer>();
		int sum=0;
		for (Sensor sensor : sesnsorlist) {
			sensorid.add(sensor.getId());
		}
		List<CO2Data> allCO2Data =co2Service.getAllC02Values();
		List<CO2Data> filteredCO2Data = allCO2Data.stream().filter(c->sensorid.contains(c.getSensor().getId()) && convertToLocalDateViaMilisecond(c.getTime()).equals(date) ).collect(Collectors.toList());
		
		for (CO2Data cO2Data : filteredCO2Data) {
			sum = sum+cO2Data.getValue();
		}
		
		return  sum/sesnsorlist.size();
	}
	
	public LocalDate convertToLocalDateViaMilisecond(Date dateToConvert) {
	    return Instant.ofEpochMilli(dateToConvert.getTime())
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
}
