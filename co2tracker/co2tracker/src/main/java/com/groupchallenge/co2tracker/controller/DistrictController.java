package com.groupchallenge.co2tracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.groupchallenge.co2tracker.model.District;
import com.groupchallenge.co2tracker.service.DistrictService;

@RestController
@RequestMapping("api/district")
public class DistrictController {

	@Autowired
	DistrictService districtService;

	@GetMapping("/{id}")
	private District getDistrict(@PathVariable("id") int id)
	{
		return districtService.getDistrictById(id);
	}

	@PostMapping("/")
	private int saveDistrict(@RequestBody District district)
	{
		districtService.saveOrUpdate(district);
		return district.getId();
	}

}
