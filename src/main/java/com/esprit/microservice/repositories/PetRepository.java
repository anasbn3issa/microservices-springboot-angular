package com.esprit.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.entities.Pet;

public interface PetRepository extends JpaRepository<Pet,Integer> {


}
