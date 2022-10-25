package com.esprit.microservice.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RedisHash("Sterilization")
public class Sterilization implements Serializable{
	private static final long serialVersionUID = 6;
	@Id
	private String id;
	
	private @NonNull  String petId;
	private @NonNull Date date;
	private @NonNull String remarks;
	private @NonNull Double fee;
	private Pet pet;
	private Veterinarian veterinarian;
	
	//FK
    private @NonNull String veterinarianId;
	
	

	
	public Sterilization(String petId, Date date, String remarks, Double fee, String veterinarianId) {
		super();
		this.petId = petId;
		this.date = date;
		this.remarks = remarks;
		this.fee = fee;
		this.veterinarianId = veterinarianId;
	}
	
	
	
	
	
}
