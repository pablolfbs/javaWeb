package com.pablo.teste;

import com.pablo.model.Person;
import com.pablo.service.PersonService;

public class TestesUnitarios {
	
	public static void main(String[] args) {
		
		Person person = new Person(15);
		PersonService personService = new PersonService();
		boolean adult = personService.isAdult(person);
		System.out.println(adult);
		
	}

}
