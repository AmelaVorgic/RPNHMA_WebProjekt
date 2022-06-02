package com.rpnhma.rpnhma_webApplication;

import com.rpnhma.rpnhma_webApplication.commons.Category;
import com.rpnhma.rpnhma_webApplication.model.Comment;
import com.rpnhma.rpnhma_webApplication.model.Post;
import com.rpnhma.rpnhma_webApplication.model.Role;
import com.rpnhma.rpnhma_webApplication.model.User;
import com.rpnhma.rpnhma_webApplication.repositpry.RoleRepository;
import com.rpnhma.rpnhma_webApplication.repositpry.UserRepository;
import com.rpnhma.rpnhma_webApplication.service.CommentService;
import com.rpnhma.rpnhma_webApplication.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class RpnhmaWebApplication {



	public static void main(String[] args) {
		SpringApplication.run(RpnhmaWebApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CommentService commentService, RoleRepository roleRepository, UserService userService, UserRepository userRepository) {
		return args -> {

			User user1 = new User();
			user1.setUsername("User1");
			user1.setPassword("pass123");
			user1.setEmail("email@email.com");
			Role role = roleRepository.findRoleByName("USER");
			Set<Role> roles = new HashSet<>();
			roles.add(role);
			user1.setRoles(roles);
			userService.signUp(user1);

			//Load posts
			List<Category> categories = new ArrayList<>();
			categories.add(Category.TARANTULAS);

			Post post1 = new Post(4L, "Chromatopelma",
					"Cyaneopubescens ",
					LocalDateTime.now(), "https://www.spidersworld.eu/193-large_default/brachypelma-smithi-l1.jpg", categories, 30, user1);
			Post post2 = new Post(5L, "Bracyphelma",
					"Hamorii ", LocalDateTime.now(), "https://www.spidersworld.eu/193-large_default/brachypelma-smithi-l1.jpg", categories, 40, user1);
			Post post3 = new Post(6L, "Tlitolocotl",
					"albopilosum ", LocalDateTime.now(), "https://www.spidersworld.eu/193-large_default/brachypelma-smithi-l1.jpg", categories, 50, user1);

			//Load comments
			Comment comment1 = new Comment(12L, "Comment 1", LocalDateTime.now(), user1, post1);
			Comment comment2 = new Comment(13L, "Comment 2", LocalDateTime.now(), user1, post2);
			Comment comment3 = new Comment(14L, "Comment 3", LocalDateTime.now(), user1, post3);

			commentService.create(comment1);
			commentService.create(comment2);
			commentService.create(comment3);

			//Load authorities
			Role adminRole = new Role();
			adminRole.setName("ADMIN");
			adminRole.setId(1L);
			Role userRole = new Role();
			userRole.setName("USER");
			userRole.setId(2L);
			roleRepository.save(adminRole);
			roleRepository.save(userRole);
		};
	}

}
