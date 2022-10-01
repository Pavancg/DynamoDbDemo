package com.cgpk.dynamodb.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

@Configuration
public class DynamoDBConfiguration {

	@Value("${aws.dynamodb.endpoint}")
	private String dynamoDbEndPoint;
	@Value("${aws.dynamodb.accesskey}")
	private String accessKey;
	@Value("${aws.dynamodb.secretkey}")
	private String secretKey;
	@Value("${aws.dynamodb.region}")
	private String region;
	
	@Bean
	public DynamoDBMapper dynamodbMapper() {
		return new DynamoDBMapper(amazonDynamoDB());
	}

	private AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(dynamoDbEndPoint, region))
				.withCredentials(amazonDynamoDBCrdentials()).build();
	}

	private AWSCredentialsProvider amazonDynamoDBCrdentials() {
		return new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey));
	}


}
