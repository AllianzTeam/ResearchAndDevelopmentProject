package com.groupchallenge.co2tracker.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity  
@Table
public class Customer {
	
	@Id
	@Column
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column
	private String name;
	@Column
	private String street;
	@Column
	private Integer zip;
	@Column
	private Integer phone;

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
