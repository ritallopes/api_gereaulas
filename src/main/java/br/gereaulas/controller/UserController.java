package br.gereaulas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gereaulas.model.User;
import br.gereaulas.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository repository;

	// GET para obter todos os usuários
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = repository.findAll();
		System.out.println(users);
		return ResponseEntity.ok(users);
	}

	// POST para criar um usuário
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User newUser) {
		System.out.println(newUser.toString());
		List<User> otherUser = repository.findByEmail(newUser.getEmail());
		//TODO testar
		if(otherUser.size() > 0) {
			return ResponseEntity.unprocessableEntity().build();
		}
		User savedUser = repository.save(newUser);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// GET para obter um usuário pelo ID
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		Optional<User> user = repository.findById(userId);

		// Verifica se o usuário com o ID fornecido existe
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	// GET para obter um usuário pelo ID
		@GetMapping("/email/{email}")
		public ResponseEntity<User> getUserByEmail(@PathVariable String email) {
			User user = repository.findByEmail(email).get(0);
			System.out.println(user.toString());

			// Verifica se o usuário com o ID fornecido existe
			if (user.getId() != null) {
				return ResponseEntity.ok(user);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
}