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
import com.esprit.microservice.entities.Veterinarian;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.esprit.microservice.service.SterilizationService;
import com.esprit.microservice.service.VeterinarianService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;


@RestController
@CrossOrigin("*")
@RequestMapping(value= "/veterinarians")
public class VeterinarianRestAPI {
	@Autowired
	private VeterinarianService veterinarianService;

	
	@GetMapping
	@ResponseStatus (HttpStatus.OK)
    public List<Veterinarian> getAllProducts() {
        return veterinarianService.findAll();
    }

    @GetMapping("/{id}")
    public Veterinarian findVeterinarian(@PathVariable String id) {
        return veterinarianService.findJobById(id);
    }
    
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Veterinarian> createVeterinarian (@RequestBody Veterinarian veterinarian) {
	return new ResponseEntity<>(veterinarianService.addSterilization(veterinarian), HttpStatus.OK);
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Veterinarian> updateVeterinarian (@PathVariable (value= "id") String id,
	@RequestBody Veterinarian veterinarian){
		return new ResponseEntity<>(veterinarianService.updateSterilization(id, veterinarian), HttpStatus.OK);
	}
	
	@DeleteMapping (value ="/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus (HttpStatus.OK)
	public ResponseEntity<String> deleteVeterinarian (@PathVariable(value="id") String id){
	return new ResponseEntity<>(veterinarianService.deleteSterilization(id) , HttpStatus.OK);
	}
}