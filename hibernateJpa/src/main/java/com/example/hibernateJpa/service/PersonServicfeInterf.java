package com.example.hibernateJpa.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;

import com.example.hibernateJpa.dtos.CreatePersonDto;
import com.example.hibernateJpa.model.Person;

@ConditionalOnMissingFilterBean
public interface PersonServicfeInterf {

	void createPersonStatic(CreatePersonDto createPersonDto);
	
	Person getPersonById(int id);
	
	void deletePerson(int id);
	
	List<Person> getAllPersons() throws SQLException;
}
