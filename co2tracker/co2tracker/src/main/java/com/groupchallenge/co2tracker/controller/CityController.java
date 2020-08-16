package com.groupchallenge.co2tracker.controller;

import com.groupchallenge.co2tracker.model.City;
import com.groupchallenge.co2tracker.repository.CityRepository;
import com.groupchallenge.co2tracker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.*;

import com.groupchallenge.co2tracker.model.City;
import com.groupchallenge.co2tracker.service.CityService;

@RestController
@RequestMapping("api/city")
public class CityController {

	@Autowired CityService cityService;

	@Autowired CityRepository cityRepository;

	@GetMapping("/{id}")
	private City getCity(@PathVariable("id") int id)
	{
		return cityService.getCityById(id);
	}

	@PostMapping("/")
	private int saveCity(@RequestBody City city)
	{
		System.out.println("Inside CitySave");
		cityService.saveOrUpdate(city);
		return city.getId();
	}

	@GetMapping("/cities")
	public List getAllCities() {
		return  (List)cityRepository.findAll();
	}

}
