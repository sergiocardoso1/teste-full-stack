package com.sergiocardoso.backend.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sergiocardoso.backend.service.impl.DBServiceImpl;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	private DBServiceImpl dbService;
	
	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}
	

}
