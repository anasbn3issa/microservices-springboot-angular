package com.esprit.microservice.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionMessage.ItemsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.esprit.microservice.VeterinarianRestAPI;
import com.esprit.microservice.entities.Pet;
import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.entities.Veterinarian;
import com.esprit.microservice.repositories.SterilizationRepository;

@Service
public class SterilizationService {
	
	@Autowired SterilizationRepository repo;
	
	@Value("${petMS.base}")
    private String petMS;
	
	@Value("${vetoMS.base}")
    private String vetoMS;

	
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
			
			restTemplate = new RestTemplate();
			
			ResponseEntity<Veterinarian> vetoresponse =
					  restTemplate.getForEntity(
							  vetoMS+"/"+sterilization.getVeterinarianId(),
							  Veterinarian.class);
			 System.out.println(vetoresponse.getBody());
			 if(vetoresponse.getStatusCode() == HttpStatus.OK)
				{
				 Veterinarian veterinarian = vetoresponse.getBody();
				 System.out.println(veterinarian.getName());
				 if(veterinarian != null)
					 sterilization.setVeterinarian(veterinarian);
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
		Sterilization ster = repo.save(Sterilization);
		 System.out.println("addSterilization");
		try {
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Veterinarian> vetoresponse =
				  restTemplate.getForEntity(
						  vetoMS+"/"+Sterilization.getVeterinarianId(),
						  Veterinarian.class);
		 System.out.println("getting veto");
		 System.out.println(vetoresponse.getStatusCode());
		 if(vetoresponse.getStatusCode() == HttpStatus.OK)
			{
			 Veterinarian veterinarian = vetoresponse.getBody();
			 if(veterinarian != null)
			 {
				 restTemplate = new RestTemplate();
				 if(veterinarian.getItems() != null || ! veterinarian.getItems().isEmpty())
					 veterinarian.getItems().add(ster.getId());
				 else {
					 Set<String> set4 = new HashSet<>();
				      set4.add(ster.getId());
				      veterinarian.setItems(set4);
				 }
				 System.out.println("preparing veto");
				 System.out.println(veterinarian);

				 restTemplate.put(vetoMS+"/"+veterinarian.getId(), veterinarian, Veterinarian.class);
			}
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ster;
	}
	
	public Sterilization updateSterilization (String id, Sterilization newSterilization ) {
		System.out.println(newSterilization);
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
			String veotId = repo.findById(id).get().getVeterinarianId();
			repo.deleteById (id);
			
			try {
				RestTemplate restTemplate = new RestTemplate();
				
				ResponseEntity<Veterinarian> vetoresponse =
						  restTemplate.getForEntity(
								  vetoMS+"/"+veotId,
								  Veterinarian.class);
				 System.out.println("getting veto");
				 System.out.println(vetoresponse.getStatusCode());
				 if(vetoresponse.getStatusCode() == HttpStatus.OK)
					{
					 Veterinarian veterinarian = vetoresponse.getBody();
					 if(veterinarian != null)
					 {
						 restTemplate = new RestTemplate();
						 if(veterinarian.getItems() != null || ! veterinarian.getItems().isEmpty())
							 
						 System.out.println("preparing veto");
						 veterinarian.getItems().remove(id);
						 System.out.println(veterinarian);
						 restTemplate.put(vetoMS+"/"+veterinarian.getId(), veterinarian, Veterinarian.class);
					}
					}
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			
			return "Sterilization supprimé;";
		}
		else
			return "Sterilization non supprimé";
	}
}
