package com.esprit.microservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.microservice.entities.Pet;
import com.esprit.microservice.repositories.PetRepository;

@Service
public class PetService {
	
	@Autowired
	private PetRepository petRepository;
	
	public Pet addPet (Pet Pet) {
		return petRepository.save(Pet);
	}
	
	public Pet updatePet (int id, Pet newPet ) {
		if (petRepository.findById(id).isPresent()) {
		Pet existingPet = petRepository.findById(id).get();
		existingPet.setAge (newPet.getAge());
		existingPet.setName(newPet.getName());
		existingPet.setRace(newPet.getRace());
		existingPet.setType(newPet.getType());
		
		existingPet.setVaccines(newPet.getVaccines());
		existingPet.setCaptureDate(newPet.getCaptureDate());
		existingPet.setLocal_id(newPet.getLocal_id());
		return petRepository.save(existingPet);
		}else
			return null;
	}
	
	public String deletePet (int id) {
		if (petRepository.findById (id).isPresent()) {
			petRepository.deleteById (id);
			return "Pet supprimé;";
		}
		else
			return "Pet non supprimé";
	}
	
	

}
