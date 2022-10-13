package com.esprit.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.repositories.SterilizationRepository;

@Service
public class SterilizationService {
	
	@Autowired
	private SterilizationRepository sterilizationRepository;
	
	public Sterilization addSterilization (Sterilization Sterilization) {
		return sterilizationRepository.save(Sterilization);
	}
	
	public Sterilization updateSterilization (int id, Sterilization newSterilization ) {
		if (sterilizationRepository.findById(id).isPresent()) {
		Sterilization existingSterilization = sterilizationRepository.findById(id).get();
		existingSterilization.setDate (newSterilization.getDate());
		existingSterilization.setFee(newSterilization.getFee());
		existingSterilization.setRemarks(newSterilization.getRemarks());
		return sterilizationRepository.save(existingSterilization);
		}else
			return null;
	}
	
	public String deleteSterilization (int id) {
		if (sterilizationRepository.findById (id).isPresent()) {
			sterilizationRepository.deleteById (id);
			return "Sterilization supprimé;";
		}
		else
			return "Sterilization non supprimé";
	}
	
	

}
