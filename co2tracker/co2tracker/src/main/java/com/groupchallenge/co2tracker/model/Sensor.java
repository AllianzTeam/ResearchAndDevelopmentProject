package com.groupchallenge.co2tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table
public class Sensor {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private String registrationDetails;

	@Column
	private Integer districtId;

	public String getRegistrationDetails() {
		return registrationDetails;
	}

	public void setRegistrationDetails(String registrationDetails) {
		this.registrationDetails = registrationDetails;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

}
