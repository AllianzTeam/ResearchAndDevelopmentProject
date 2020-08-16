package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.City;
import com.groupchallenge.co2tracker.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

	@Autowired CityRepository cityRepository;

	public City getCityById(int id)   {

		return cityRepository.findById(id).get();
	}

	public void saveOrUpdate(City city)   {

		cityRepository.save(city);
	}

}
