package com.cgpk.dynamodb.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpk.dynamodb.entity.Person;
import com.cgpk.dynamodb.repository.PersonRepository;
import com.cgpk.dynamodb.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	private PersonRepository repository;
	
	@Override
	public Person save(Person person) {
		return repository.save(person);
	}

	@Override
	public String delete(String id) {
		return repository.delete(id);
	}

	@Override
	public String update(String id, Person person) {
		return repository.update(id, person);
	}

	@Override
	public Person findById(String id) {
		return repository.findById(id);
	}

	@Override
	public List<Person> findAll() {
		return repository.findAll();
	}

}
