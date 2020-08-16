package com.groupchallenge.co2tracker.service;

import com.groupchallenge.co2tracker.model.District;
import com.groupchallenge.co2tracker.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictService {
	@Autowired DistrictRepository districtRepository;

	public District getDistrictById(int id)   {

		return districtRepository.findById(id).get();
	}

	public void saveOrUpdate(District district)   {

		districtRepository.save(district);
	}
}
