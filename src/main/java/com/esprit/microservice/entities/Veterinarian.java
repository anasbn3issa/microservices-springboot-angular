package com.esprit.microservice.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Veterinarian {
	private static final long serialVersionUID = 6;

	@Id
	@GeneratedValue
	private int veterinarian_id;
	
	private int pet_id;
	private String name, address, phone, email;
	@OneToMany(mappedBy="veterinarian")
    private Set<Sterilization> items;
	public Veterinarian(int veterinarian_id, int pet_id, String name, String address, String phone, String email,
			Set<Sterilization> items) {
		super();
		this.veterinarian_id = veterinarian_id;
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian(int pet_id, String name, String address, String phone, String email,
			Set<Sterilization> items) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian(int pet_id, String name, String address, String phone, String email) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public int getVeterinarian_id() {
		return veterinarian_id;
	}

	public void setVeterinarian_id(int veterinarian_id) {
		this.veterinarian_id = veterinarian_id;
	}

	public int getPet_id() {
		return pet_id;
	}

	public void setPet_id(int pet_id) {
		this.pet_id = pet_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Sterilization> getItems() {
		return items;
	}

	public void setItems(Set<Sterilization> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Veterinarian [veterinarian_id=" + veterinarian_id + ", pet_id=" + pet_id + ", name=" + name
				+ ", address=" + address + ", phone=" + phone + ", email=" + email + ", items=" + items + "]";
	}
	
	

	

}
