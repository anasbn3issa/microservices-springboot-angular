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
	private @NonNull Date date;
	private @NonNull String remarks;
	private @NonNull Double fee;
	
	//FK
    private @NonNull String veterinarian;
	
	

	
	public Sterilization(Date date, String remarks, Double fee, String veterinarian) {
		super();
		this.date = date;
		this.remarks = remarks;
		this.fee = fee;
		this.veterinarian = veterinarian;
	}
	
	
	
	
	
}
