package com.groupchallenge.co2tracker.controller;

import com.groupchallenge.co2tracker.model.CO2Data;
import com.groupchallenge.co2tracker.repository.Co2Repository;
import com.groupchallenge.co2tracker.service.Co2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/co2tracker")
public class Co2Controller {
	@Autowired Co2Service co2Service;
	@Autowired Co2Repository co2Repository;

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
}
