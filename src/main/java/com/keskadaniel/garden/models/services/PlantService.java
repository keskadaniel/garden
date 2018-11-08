package com.keskadaniel.garden.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keskadaniel.garden.models.PlantEntity;
import com.keskadaniel.garden.models.forms.PlantForm;
import com.keskadaniel.garden.models.repositories.PlantRepository;
import com.keskadaniel.garden.models.repositories.UserRepository;

@Service
public class PlantService {
	
	@Autowired
	PlantRepository plantRepository;
		
	@Autowired
	UserService userService;
	
	private PlantEntity plantEntity;
	
	
	public void addPlant (PlantForm plantForm) {
		
		PlantEntity newPlant = new PlantEntity();
		
		newPlant.setName(plantForm.getName());
		newPlant.setDescription(plantForm.getDescription());
		newPlant.setUser(userService.getUserData());;
		
		plantRepository.save(newPlant);
				
	}
	
	public void addPlant(PlantEntity plantEntity) {
		
		plantRepository.save(plantEntity);
	}

	public PlantEntity getPlantEntity() {
		return plantEntity;
	}

	public void setPlantEntity(PlantEntity plantEntity) {
		this.plantEntity = plantEntity;
	}
	
	public Optional<PlantEntity> getPlantById(int id) {
		
		return plantRepository.findById(id);
		
	}
	
public Iterable<PlantEntity> getAllPlantsByUser(int userId){
		
		return plantRepository.findByUserId(userId);
	}


	
}
