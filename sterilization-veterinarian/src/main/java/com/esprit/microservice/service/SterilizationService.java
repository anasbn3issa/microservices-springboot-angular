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
import com.esprit.microservice.repositories.SterilizationRepository;

@Service
public class SterilizationService {
	
	@Autowired SterilizationRepository repo;
	
	@Value("${petMS.base}")
    private String petMS;

	
	public List<Sterilization> findAll(){
		RestTemplate restTemplate = new RestTemplate();

		List<Sterilization> list = (List<Sterilization>) repo.findAll();
		System.out.println(petMS);
		try {
		for (Sterilization sterilization : list) {
			ResponseEntity<Pet> response =
					  restTemplate.getForEntity(
							  petMS+"/pets/"+sterilization.getPetId(),
					  Pet.class);
			 System.out.println(response.getBody());
			if(response.getStatusCode() == HttpStatus.OK)
			{
			 Pet pet = response.getBody();
			 System.out.println(pet.getName());
			 if(pet != null)
				 sterilization.setPet(pet);
			}
			
		}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
    }

	public Pet[] getPets(){
		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<Pet[]> response =
				  restTemplate.getForEntity(
						  petMS+"/pets/",
				  Pet[].class);

		Pet[] pets = response.getBody();
		return pets;
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
