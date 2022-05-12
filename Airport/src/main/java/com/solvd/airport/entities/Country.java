package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "country")

@XmlType(propOrder = { "countryId", "name" })
public class Country {
	private long countryId;
	private String name;

	public Country() {
	};

	public Country(long countryId, String name) {
		this.countryId = countryId;
		this.name = name;
	}

	public Country(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + "]";
	}

	public long getCountryId() {
		return countryId;
	}

	@XmlAttribute
	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

}
