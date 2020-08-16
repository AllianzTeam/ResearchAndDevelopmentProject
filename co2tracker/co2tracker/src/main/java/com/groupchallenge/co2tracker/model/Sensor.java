package com.groupchallenge.co2tracker.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table
public class Sensor {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private String registrationDetails;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "DISTRICT_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private District district;

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

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}
}
