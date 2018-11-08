package com.keskadaniel.garden.models.repositories;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keskadaniel.garden.models.PlantEntity;

@Repository
public interface PlantRepository extends CrudRepository<PlantEntity, Integer> {
				
	Optional<PlantEntity> findById(int id);

	Iterable<PlantEntity> findAllById(int Id);
	
	Iterable<PlantEntity> findByUserId(int userId);
	
	
	
}



