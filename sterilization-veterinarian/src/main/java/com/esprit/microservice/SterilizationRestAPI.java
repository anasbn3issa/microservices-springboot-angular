package com.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.microservice.entities.Pet;
import com.esprit.microservice.entities.Sterilization;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.esprit.microservice.service.SterilizationService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;


@RestController
@CrossOrigin("*")
@RequestMapping(value= "/sterilizations")
public class SterilizationRestAPI {
	@Autowired
	private SterilizationService sterilizationService;

	
	@GetMapping
	@ResponseStatus (HttpStatus.OK)
    public List<Sterilization> getAllProducts() {
        return sterilizationService.findAll();
    }

	@GetMapping("/pets")
	@ResponseStatus (HttpStatus.OK)
    public Pet[] getPets() {
        return sterilizationService.getPets();
    }

    @GetMapping("/{id}")
    public Sterilization findJob(@PathVariable String id) {
        return sterilizationService.findJobById(id);
    }
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Sterilization> createSterilization (@RequestBody Sterilization sterilization) {
	return new ResponseEntity<>(sterilizationService.addSterilization(sterilization), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sterilization> updateSterilization (@PathVariable (value= "id") String id,
	@RequestBody Sterilization sterilization){
		return new ResponseEntity<>(sterilizationService.updateSterilization(id, sterilization), HttpStatus.OK);
	}
	
	@DeleteMapping (value ="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<String> deleteSterilization (@PathVariable(value="id") String id){
	return new ResponseEntity<>(sterilizationService.deleteSterilization(id) , HttpStatus.OK);
	}
}