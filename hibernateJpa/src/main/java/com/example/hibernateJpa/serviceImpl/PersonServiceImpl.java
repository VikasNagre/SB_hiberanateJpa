package com.example.hibernateJpa.serviceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernateJpa.dtos.CreatePersonDto;
import com.example.hibernateJpa.exception.PersonNotFoundException;
import com.example.hibernateJpa.model.Person;
import com.example.hibernateJpa.repository.PersonRepositoryInterf;


@Service
public class PersonServiceImpl {
	
	@Autowired
	PersonRepositoryInterf personRepositoryInterf;
	
	public void createPersonStatic(CreatePersonDto createPersonDto) {
		Person person = createPersonDto.to();
		
		if(person.getAge() == null)
			person.setAge(calculateAgeFromDOB(person.getDob()));
		personRepositoryInterf.save(person);		
	}
	
	private Integer calculateAgeFromDOB(String dob) {
		if(dob == null) {
			return null;
		}
		LocalDate dobDate = LocalDate.parse(dob);
		LocalDate currentDate = LocalDate.now();
		
		return Period.between(dobDate, currentDate).getYears();

	}

	public Person getPersonById(int id) {
		return personRepositoryInterf.findById(id).orElseThrow(
				() -> new PersonNotFoundException("person with Id "+id+" not Present!"));
	}

	public void deletePerson(int id) {
		personRepositoryInterf.deleteById(id);
	}

	public List<Person> getAllPersons() throws SQLException {
		return personRepositoryInterf.findAll();
	}

	

}
