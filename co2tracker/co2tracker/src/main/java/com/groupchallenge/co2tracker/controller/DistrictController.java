package com.groupchallenge.co2tracker.controller;

import com.groupchallenge.co2tracker.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.groupchallenge.co2tracker.model.District;
import com.groupchallenge.co2tracker.service.DistrictService;

import java.util.List;

@RestController
@RequestMapping("api/district")
public class DistrictController {

	@Autowired
	DistrictService districtService;

	@Autowired
	DistrictRepository districtRepository;

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

	@GetMapping("/districts")
	public List getAllDistricts() {
		return  (List)districtRepository.findAll();
	}

}
