package com.derya.sbes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.derya.sbes.dto.UserCreateDTO;
import com.derya.sbes.service.UserService;

//@SpringBootApplication(exclude=BatchAutoConfiguration.class)
@SpringBootApplication(exclude=SecurityAutoConfiguration.class)
public class Springbootegitimserisi1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootegitimserisi1Application.class, args);
	}

	@Bean
	CommandLineRunner createInitialUser(UserService userService) {
		return (args)->{
			UserCreateDTO userCreateDTO = new UserCreateDTO();
			userCreateDTO.setUserName("User1");
			userCreateDTO.setFirstName("dfghjk");
			userCreateDTO.setLastName("rfghujkl");
			
			userService.createUser(userCreateDTO);
			
			UserCreateDTO user2 = new UserCreateDTO();
			user2.setUserName("User2");
			user2.setFirstName("sdfghjk");
			user2.setLastName("edfghj");
			
			userService.createUser(user2);
					
			UserCreateDTO user3 = new UserCreateDTO();
			user3.setUserName("User3");
			user3.setFirstName("edfghjk");
			user3.setLastName("dfghjk");
			
			userService.createUser(user3);
		};
	}
}
