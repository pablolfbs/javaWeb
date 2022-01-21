package com.pablo.service.teste;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.pablo.model.Person;
import com.pablo.service.PersonService;

public class PersonServiceTest {
	
	@Test
	public void isAdultFalseAgeLower18() {
		Person person = new Person(15);
		PersonService personService = new PersonService();
		Assertions.assertEquals(false, personService.isAdult(person));
	}
}
