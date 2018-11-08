package com.keskadaniel.garden.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.keskadaniel.garden.models.ActionEntity;
import com.keskadaniel.garden.models.PlantEntity;

@Repository
public interface ActionRepository extends CrudRepository<ActionEntity, Integer> {

	Iterable<ActionEntity> findByUserId(int userId);
	Iterable<ActionEntity> findByUserIdAndMonth(int userId, int month);
	Iterable<ActionEntity> findByMonth(int month);
	Iterable<ActionEntity> findAll();

	
}
