package com.example.tictactoe.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoDbConfig 
{ 
    @Bean
    public MongoClient mongo() 
    {
        //ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/tictactoeDB");
        ConnectionString connectionString = new ConnectionString("mongodb+srv://jawad:jawad@cluster0.pbe0u.mongodb.net/tictactoeDB");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
          .applyConnectionString(connectionString)
          .build();
        
          return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception 
    {
        return new MongoTemplate(mongo(), "tictactoeDB");
    }
}
