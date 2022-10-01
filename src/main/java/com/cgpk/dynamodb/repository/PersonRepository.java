package com.cgpk.dynamodb.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.cgpk.dynamodb.entity.Person;

@Repository
public class PersonRepository {

	@Autowired
	private DynamoDBMapper dynamoDbMapper;
	
	
	public Person save(Person person) {
		dynamoDbMapper.save(person);
		return person;
	}
	
	public Person findById(String id) {
		return dynamoDbMapper.load(Person.class, id);
	}
	
	public List<Person> findAll() {
		return dynamoDbMapper.scan(Person.class,new DynamoDBScanExpression());
	}
	
	public String update(String id,Person person) {
		dynamoDbMapper.save(person,  new DynamoDBSaveExpression()
				.withExpectedEntry("personid", new ExpectedAttributeValue(
						new AttributeValue(id))));
		return id;
	}
	
	public String delete(String id) {
		Person person = dynamoDbMapper.load(Person.class, id);
		dynamoDbMapper.delete(person);
		return "person deleted successfully "+id;
	}
}
