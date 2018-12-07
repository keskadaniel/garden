package com.keskadaniel.garden.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keskadaniel.garden.models.ActionEntity;
import com.keskadaniel.garden.models.PlantEntity;
import com.keskadaniel.garden.models.forms.ActionForm;
import com.keskadaniel.garden.models.repositories.ActionRepository;


@Service
public class ActionService {
	
	@Autowired
	PlantService plantService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ActionRepository actionRepository;
	
	public void addAction (ActionForm actionForm, int plantId) {
		
		PlantEntity plantEntity = new PlantEntity();
		plantEntity.setId(plantId);
		
		ActionEntity act = new ActionEntity();
		
		act.setName(actionForm.getName());
		act.setDescription(actionForm.getDescription());
		act.setPlant(plantEntity);
		act.setUser(userService.getUserData());
		act.setMonth(actionForm.getMonth());
		
		actionRepository.save(act);
				
	}
	
	public void addAction (ActionEntity actionEntity) {
		
		actionRepository.save(actionEntity);
	}
	
public void deleteAction(int id) {
	
    ActionEntity actionEntity = new ActionEntity();
    actionEntity.setId(id);
		
		actionRepository.delete(actionEntity);
	}

	public Iterable<ActionEntity> getAllActionsByUser(int id) {
		
		return actionRepository.findByUserId(id);
	}
	

}
