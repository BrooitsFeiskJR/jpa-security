package com.tontech.Spring.Security.JPA;

import com.tontech.Spring.Security.JPA.model.Post;
import com.tontech.Spring.Security.JPA.model.User;
import com.tontech.Spring.Security.JPA.repository.PostRepository;
import com.tontech.Spring.Security.JPA.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository postRepository, UserRepository userRepository, PasswordEncoder encoder) {
		return args -> {
			userRepository.save(new User("user", encoder.encode("password"), "ROLE_USER"));
			userRepository.save(new User("admin", encoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
			postRepository.save(new Post("Hello World", "hello-world", "Welcome to my blog", "Luiz"));
		};
	}
}
