package com.example.oshopbackend.config;

import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.util.Objects;

@Configuration
public class MongoConfig {

    @Autowired
    private Environment env ;

    @Bean
    public MongoDatabaseFactory mongodbFactory(){
        return  new SimpleMongoClientDatabaseFactory(
                MongoClients.create(
                        Objects.requireNonNull(env.getProperty("spring.data.mongodb.uri"))),
                        Objects.requireNonNull(env.getProperty("spring.data.mongodb.database"))

        );
    }

    @Bean
    public MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongodbFactory());
    }

}
