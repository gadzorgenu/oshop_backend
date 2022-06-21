package com.example.oshopbackend;

import com.example.oshopbackend.dao.ProductDao;
import com.example.oshopbackend.dao.UserDao;
import com.example.oshopbackend.entities.Product;
import com.example.oshopbackend.enums.CATEGORY;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class OshopBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OshopBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductDao productDao, UserDao user){
		return args -> {
			Product product = new Product("Tomatoes", BigDecimal.valueOf(24.59),"dfd", CATEGORY.VEGETABLES);
			productDao.findPoductByName("");
			productDao.insert(product);

		};
	}
}
