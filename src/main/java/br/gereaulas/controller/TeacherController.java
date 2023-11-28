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

import br.gereaulas.model.Teacher;
import br.gereaulas.repository.TeacherRepository;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
	@Autowired
	private TeacherRepository repository;

	// GET para obter todos os usuários
	@GetMapping
	public ResponseEntity<List<Teacher>> getAllTeachers() {
		List<Teacher> teachers = repository.findAll();
		System.out.println(teachers);
		return ResponseEntity.ok(teachers);
	}

	// POST para criar um usuário
	@PostMapping
	public ResponseEntity<Teacher> createTeachers(@RequestBody Teacher newTeacher) {
		List<Teacher> otherUser = repository.findByEmail(newTeacher.getEmail());
		// TODO testar
		if (otherUser.size() > 0) {
			return ResponseEntity.unprocessableEntity().build();
		}
		Teacher savedUser = repository.save(newTeacher);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// GET para obter um usuário pelo ID
	@GetMapping("/{teacherId}")
	public ResponseEntity<Teacher> getUserById(@PathVariable Long teacherId) {
		Optional<Teacher> user = repository.findById(teacherId);

		// Verifica se o usuário com o ID fornecido existe
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// GET para obter um usuário pelo ID
	@GetMapping("/email/{email}")
	public ResponseEntity<Teacher> getUserByEmail(@PathVariable String email) {
		Teacher user = repository.findByEmail(email).get(0);
		System.out.println(user.toString());

		// Verifica se o usuário com o ID fornecido existe
		if (user.getId() != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
