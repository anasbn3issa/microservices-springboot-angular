package com.esprit.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.microservice.entities.Pet;
import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.entities.Veterinarian;
import com.esprit.microservice.repositories.SterilizationRepository;
import com.esprit.microservice.repositories.VeterinarianRepository;

@Service
public class VeterinarianService {
	
	@Autowired VeterinarianRepository repo;
	


	
	public List<Veterinarian> findAll(){
		List<Veterinarian> list = (List<Veterinarian>) repo.findAll();
		return list;
    }
	
    public Veterinarian findJobById(String id){
        return repo.findById(id).get();
        
    }

	
	public Veterinarian addSterilization (Veterinarian Sterilization) {
		return repo.save(Sterilization);
	}
	
	public Veterinarian updateSterilization (String id, Veterinarian newVeterinarian ) {
		System.out.println(newVeterinarian);
		if (repo.findById(id).isPresent()) {
			Veterinarian existingVeterinarian = repo.findById(id).get();
			existingVeterinarian.setName(newVeterinarian.getName());
			existingVeterinarian.setAddress(newVeterinarian.getAddress());
			existingVeterinarian.setEmail(newVeterinarian.getEmail());
			existingVeterinarian.setPhone(newVeterinarian.getPhone());
			existingVeterinarian.setItems(newVeterinarian.getItems());
		return repo.save(existingVeterinarian);
		}else
			return null;
	}
	
	public String deleteSterilization (String id) {
		if (repo.findById (id).isPresent()) {
			repo.deleteById (id);
			return "Veterinarian supprimé;";
		}
		else
			return "Veterinarian non supprimé";
	}
}
