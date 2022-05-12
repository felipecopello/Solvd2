package com.solvd.airport.entities;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlRootElement(name = "person")
@XmlType(propOrder = { "name", "age" })
public class Person {
	private String name;
	private int age;

	public Person() {
	};

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	@XmlElement(name = "name")
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@XmlElement(name = "age")
	public void setAge(int age) {
		this.age = age;
	}
}
