package com.pablo.service;

import java.util.Objects;

import com.pablo.model.Person;

public class PersonService {
	
	public boolean isAdult(Person person) {
		Objects.requireNonNull(person, "Person can't be null");
		return person.getAge() >= 18;
	}
	
}
