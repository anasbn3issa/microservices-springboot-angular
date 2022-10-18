package com.esprit.microservice.entities;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Veterinarian {
	private static final long serialVersionUID = 6;

	private String veterinarian_id;
	
	private String pet_id;
	private String name, address, phone, email;
    private Set<String> items;
	public Veterinarian(String veterinarian_id, String pet_id, String name, String address, String phone, String email,
			Set<String> items) {
		super();
		this.veterinarian_id = veterinarian_id;
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian(String pet_id, String name, String address, String phone, String email,
			Set<String> items) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian(String pet_id, String name, String address, String phone, String email) {
		super();
		this.pet_id = pet_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
}
