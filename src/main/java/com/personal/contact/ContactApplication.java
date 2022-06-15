package com.personal.contact;

import com.personal.contact.entity.models.Roles;
import com.personal.contact.entity.models.Users;
import com.personal.contact.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class ContactApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveNewRole(new Roles(null,"ADMIN"));
			userService.saveNewRole(new Roles(null,"EMPLOYEE"));
			userService.saveNewRole(new Roles(null,"SuperUSER"));

			userService.saveUser(
					new Users(null,"pwong","soyboy", "Phoenix Wong", "pwong@gmail.com", new ArrayList<>())
			);
			userService.roleToUser("pwong", "EMPLOYEE");
			userService.roleToUser("pwong", "ADMIN");

		};
}
@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
}
}
