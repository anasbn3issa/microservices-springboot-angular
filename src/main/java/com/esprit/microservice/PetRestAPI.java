package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entities.Pet;
import com.esprit.microservice.service.PetService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;


@RestController
@RequestMapping(value= "/api/Pets")
public class PetRestAPI {
	private String title="Pet";
	@Autowired
	private PetService petService;

	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pet> createPet (@RequestBody Pet Pet) {
	return new ResponseEntity<>(petService.addPet(Pet), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Pet> updatePet (@PathVariable (value= "id") int id,
	@RequestBody Pet Pet){
		return new ResponseEntity<>(petService.updatePet(id, Pet), HttpStatus.OK);
	}
	
	@DeleteMapping (value ="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<String> deletePet (@PathVariable(value="id") int id){
	return new ResponseEntity<>(petService.deletePet(id) , HttpStatus.OK);
	}
}
