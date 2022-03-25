package com.example.tictactoe.config;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${aws.service-endpoint}")
    private String awsServiceEndpoint;

    @Value("${cloud.aws.region.static}")
    private String awsRegion;

    @Value("${cloud.aws.credentials.accessKey}")
    private String awsAccessKey;

    @Value("${cloud.aws.credentials.secretKey}")
    private String awsSecretKey;


    /*@Value("${accessKey}")
    private String accessKey;

    @Value("${secret}")
    private String secret;

    @Value("${region}")
    private String region;

    

    @Bean
    public AmazonS3 s3(){

        AWSCredentials awsCredentials=new BasicAWSCredentials(accessKey,secret);


       return AmazonS3ClientBuilder.standard().withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4566",region)).withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).build();

    }*/

    @Bean
public AmazonS3 amazonS3() {
return AmazonS3Client.builder()
.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(awsServiceEndpoint, awsRegion)) //(1)
.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(awsAccessKey, awsSecretKey))) //(2)
.withPathStyleAccessEnabled(true) //(3)
.build();
}

}