package com.keskadaniel.garden.models.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keskadaniel.garden.models.ActionEntity;
import com.keskadaniel.garden.models.repositories.ActionRepository;

@Service
public class DateService {

	@Autowired
	ActionRepository actionRepo;

	@Autowired
	UserService userService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	Calendar calendar = new GregorianCalendar();

	int month = calendar.get(Calendar.MONTH);

	public Iterable<ActionEntity> showMonths() {

		return actionRepo.findByUserIdAndMonth(userService.getUserData().getId(), month);

	}

}
