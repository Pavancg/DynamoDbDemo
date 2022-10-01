package com.cgpk.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.Data;

@Data
@DynamoDBDocument
public class Department {

	@DynamoDBAttribute
	private String deparmentName;
	
	@DynamoDBAttribute
	private String departmentCode;
	
}
