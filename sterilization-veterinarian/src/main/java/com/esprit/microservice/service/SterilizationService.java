package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.repositories.SterilizationRepository;

@Service
public class SterilizationService {
	
	@Autowired SterilizationRepository repo;
	
	public List<Sterilization> findAll(){
        return (List<Sterilization>) repo.findAll();
    }

    public Sterilization findJobById(String id){
        return repo.findById(id).get();
    }

	
	public Sterilization addSterilization (Sterilization Sterilization) {
		return repo.save(Sterilization);
	}
	
	public Sterilization updateSterilization (String id, Sterilization newSterilization ) {
		if (repo.findById(id).isPresent()) {
		Sterilization existingSterilization = repo.findById(id).get();
		existingSterilization.setDate (newSterilization.getDate());
		existingSterilization.setFee(newSterilization.getFee());
		existingSterilization.setRemarks(newSterilization.getRemarks());
		existingSterilization.setVeterinarian(newSterilization.getVeterinarian());
		return repo.save(existingSterilization);
		}else
			return null;
	}
	
	public String deleteSterilization (String id) {
		if (repo.findById (id).isPresent()) {
			repo.deleteById (id);
			return "Sterilization supprimé;";
		}
		else
			return "Sterilization non supprimé";
	}
}
