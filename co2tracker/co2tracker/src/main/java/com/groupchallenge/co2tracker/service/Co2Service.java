package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.CO2Data;
import com.groupchallenge.co2tracker.repository.Co2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Co2Service {
	@Autowired Co2Repository co2Repository;

	public CO2Data getCo2ById(int id)   {

		return co2Repository.findById(id).get();
	}

	public void saveOrUpdate(CO2Data co2)   {

		co2Repository.save(co2);
	}
}
