package com.solvd.airport.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "plane")
@XmlType(propOrder = { "planeId", "model", "capacity" })
public class Plane {
	@JsonProperty
	private long planeId;
	@JsonProperty
	private String model;
	@JsonProperty
	private int capacity;

	public Plane() {
	};

	public Plane(long planeId, String model, int capacity) {
		this.planeId = planeId;
		this.model = model;
		this.capacity = capacity;
	}

	public Plane(String model, Integer capacity) {
		this.model = model;
		this.capacity = capacity;
	}

	public String getModel() {
		return model;
	}

	@XmlElement(name = "model")
	public void setModel(String model) {
		this.model = model;
	}

	public Integer getCapacity() {
		return capacity;
	}

	@XmlElement(name = "capacity")
	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	@Override
	public String toString() {
		return "Plane [model=" + model + ", capacity=" + capacity + "]";
	}

	public long getPlaneId() {
		return planeId;
	}

	@XmlAttribute
	public void setPlaneId(long planeId) {
		this.planeId = planeId;
	}

}
