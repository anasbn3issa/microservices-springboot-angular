package com.esprit.microservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.microservice.entities.Sterilization;

public interface SterilizationRepository extends JpaRepository<Sterilization,Integer> {


}
