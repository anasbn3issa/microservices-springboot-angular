package com.esprit.microservice.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Pet {
	private static final long serialVersionUID = 6;
	@Id
	@GeneratedValue
	private int id;
	private String name, type, race;
	private int age;
	private Date captureDate;
	
	//foreign keys
	private int local_id, sterilization_id;
	
	@ElementCollection
	private List<Integer> vaccines;
	
	

	public Pet(int id, String name, String type, String race, int age, Date captureDate, int local_id,
			int sterilization_id, List<Integer> vaccines) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.race = race;
		this.age = age;
		this.captureDate = captureDate;
		this.local_id = local_id;
		this.sterilization_id = sterilization_id;
		this.vaccines = vaccines;
	}
	
	public Pet(String name, String type, String race, int age, Date captureDate, int local_id,
			int sterilization_id, List<Integer> vaccines) {
		super();
		this.name = name;
		this.type = type;
		this.race = race;
		this.age = age;
		this.captureDate = captureDate;
		this.local_id = local_id;
		this.sterilization_id = sterilization_id;
		this.vaccines = vaccines;
	}
	
	public Pet(String name, String type, String race, int age, Date captureDate, int local_id,
			int sterilization_id) {
		super();
		this.name = name;
		this.type = type;
		this.race = race;
		this.age = age;
		this.captureDate = captureDate;
		this.local_id = local_id;
		this.sterilization_id = sterilization_id;
		this.vaccines = vaccines;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getCaptureDate() {
		return captureDate;
	}

	public void setCaptureDate(Date captureDate) {
		this.captureDate = captureDate;
	}

	public int getLocal_id() {
		return local_id;
	}

	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}

	public int getSterilization_id() {
		return sterilization_id;
	}

	public void setSterilization_id(int sterilization_id) {
		this.sterilization_id = sterilization_id;
	}

	public List<Integer> getVaccines() {
		return vaccines;
	}

	public void setVaccines(List<Integer> vaccines) {
		this.vaccines = vaccines;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", type=" + type + ", race=" + race + ", age=" + age
				+ ", captureDate=" + captureDate + ", local_id=" + local_id + ", sterilization_id=" + sterilization_id
				+ ", vaccines=" + vaccines + "]";
	}
	
	
}
