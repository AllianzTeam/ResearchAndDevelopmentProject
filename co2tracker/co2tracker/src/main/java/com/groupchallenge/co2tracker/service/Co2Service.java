package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.CO2Data;
import com.groupchallenge.co2tracker.model.Sensor;
import com.groupchallenge.co2tracker.repository.Co2Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Co2Service {
	@Autowired Co2Repository co2Repository;

	public CO2Data getCo2ById(int id)   {

		return co2Repository.findById(id).get();
	}
	
	public List<CO2Data> getAllC02Values() {

		return (List<CO2Data>) co2Repository.findAll();
	}

	public void saveOrUpdate(CO2Data co2)   {

		co2Repository.save(co2);
	}
}
