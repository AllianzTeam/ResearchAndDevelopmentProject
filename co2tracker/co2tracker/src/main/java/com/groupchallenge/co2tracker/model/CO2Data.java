package com.groupchallenge.co2tracker.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class CO2Data {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column
	private Integer value;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "SENSOR_ID", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Sensor sensor;

	@Column
	private Date time;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Sensor getSensor() {
		return sensor;
	}

	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
