package com.esprit.microservice.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Sterilization {
	private static final long serialVersionUID = 6;
	@Id
	@GeneratedValue
	private int id;
	private Date date;
	private String remarks;
	private Double fee;
	
	@ManyToOne
    @JoinColumn(name="veterinarian_id")
    private Veterinarian veterinarian;
	
	

	public Sterilization(int id, Date date, String remarks, Double fee, Veterinarian veterinarian) {
		super();
		this.id = id;
		this.date = date;
		this.remarks = remarks;
		this.fee = fee;
		this.veterinarian = veterinarian;
	}
	
	public Sterilization(Date date, String remarks, Double fee, Veterinarian veterinarian) {
		super();
		this.date = date;
		this.remarks = remarks;
		this.fee = fee;
		this.veterinarian = veterinarian;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Veterinarian getVeterinarian() {
		return veterinarian;
	}

	public void setVeterinarian(Veterinarian veterinarian) {
		this.veterinarian = veterinarian;
	}

	@Override
	public String toString() {
		return "Sterilization [id=" + id + ", date=" + date + ", remarks=" + remarks + ", fee=" + fee
				+ ", veterinarian=" + veterinarian + "]";
	}
	
	
	
	
	
	
}
