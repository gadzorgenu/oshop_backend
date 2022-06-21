package com.example.oshopbackend.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env ;

    @Bean
    public MongoDatabaseFactory mongodbFactory(){
        return  new SimpleMongoClientDatabaseFactory(MongoClients.create(),"oshopbackend");
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongodbFactory());
    }

}
