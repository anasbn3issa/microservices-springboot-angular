package com.esprit.microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entities.Sterilization;
import com.esprit.microservice.entities.Veterinarian;

public interface VeterinarianRepository extends CrudRepository<Veterinarian,String> {


}
