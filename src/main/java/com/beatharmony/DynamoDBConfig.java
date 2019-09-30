package com.beatharmony;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.util.StringUtils;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableDynamoDBRepositories
public class DynamoDBConfig {

    @Value("${amazon.dynamodb.endpoint}")
    private String endpoint;

    @Value("${amazon.aws.accesskey}")
    private String accessKey;

    @Value("${amazon.aws.secretkey}")
    private String secretKey;

    @Bean
    public AmazonDynamoDB getAmazonDynamoDB() {
        AmazonDynamoDB db = new AmazonDynamoDBClient(getAWSCredentials());
        if (!StringUtils.isNullOrEmpty(endpoint)) {
            db.setEndpoint(endpoint);
        }
        return db;
    }

    @Bean
    public AWSCredentials getAWSCredentials() {
        return new BasicAWSCredentials(accessKey, secretKey);
    }
}
