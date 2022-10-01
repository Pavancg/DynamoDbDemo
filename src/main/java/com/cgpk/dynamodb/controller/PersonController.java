package com.cgpk.dynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgpk.dynamodb.entity.Person;
import com.cgpk.dynamodb.service.PersonService;
import com.cgpk.dynamodb.serviceimpl.PersonServiceImpl;

@RestController
public class PersonController {

	@Autowired
	private PersonService personService;
	

	@PostMapping("/person")
	public Person save(@RequestBody Person person) {
		return personService.save(person);
	}
	
	@GetMapping("/person/{personid}")
	public Person findById(@PathVariable(value ="personid") String id) {
		return personService.findById(id);
	}
	
	@GetMapping("/person")
	public List<Person> findAll(){
		return personService.findAll();
	}
	
	@PutMapping("/person/{personid}")
	public String update(@PathVariable(value = "personid") String id, @RequestBody Person person) {
		return personService.update(id, person);
	}
	
	@DeleteMapping("/person/{personid}")
	public String delete(@PathVariable(value = "personid") String id) {
		return personService.delete(id);
	}
}
