package com.esprit.microservice.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.esprit.microservice.entities.Sterilization;

public interface SterilizationRepository extends CrudRepository<Sterilization,String> {


}
