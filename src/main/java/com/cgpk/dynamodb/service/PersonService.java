package com.cgpk.dynamodb.service;

import java.util.List;

import com.cgpk.dynamodb.entity.Person;

public interface PersonService {

	public Person save(Person person);
	
	public String delete(String id);
	
	public String update(String id, Person person);
	
	public Person findById(String id);
	
	public List<Person> findAll();
	
}
