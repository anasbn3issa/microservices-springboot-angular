package com.esprit.microservice.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

@NoArgsConstructor
@RedisHash("Veterinarian")
public class Veterinarian implements Serializable{
	private static final long serialVersionUID = 6;

	@Id
	private String id;
	
	private @NonNull String name;
	private @NonNull String address;
	private @NonNull String email;
	private @NonNull String phone;
    private Set<String> items = new HashSet<>();
	public Veterinarian(String veterinarian_id, String name, String address, String phone, String email,
			Set<String> items) {
		super();
		this.id = veterinarian_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian( String name, String address, String phone, String email,
			Set<String> items) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.items = items;
	}
	
	public Veterinarian(String name, String address, String phone, String email) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
}
