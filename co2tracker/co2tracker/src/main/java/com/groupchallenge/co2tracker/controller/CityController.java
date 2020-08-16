package com.groupchallenge.co2tracker.controller;

import com.groupchallenge.co2tracker.model.City;
import com.groupchallenge.co2tracker.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupchallenge.co2tracker.model.City;
import com.groupchallenge.co2tracker.service.CityService;

@RestController
@RequestMapping("api/city")
public class CityController {

	@Autowired CityService cityService;

	@GetMapping("/{id}")
	private City getCity(@PathVariable("id") int id)
	{
		return cityService.getCityById(id);
	}

	@PostMapping("/")
	private int saveCity(@RequestBody City city)
	{
		cityService.saveOrUpdate(city);
		return city.getId();
	}

}
