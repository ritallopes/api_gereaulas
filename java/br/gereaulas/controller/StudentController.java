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

import br.gereaulas.model.Student;
import br.gereaulas.repository.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private StudentRepository repository;

	// GET para obter todos os usuários
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudents() {
		List<Student> students = repository.findAll();
		System.out.println(students);
		return ResponseEntity.ok(students);
	}

	// POST para criar um usuário
	@PostMapping
	public ResponseEntity<Student> createStudents(@RequestBody Student newStudent) {
		System.out.println(newStudent.toString());
		List<Student> otherUser = repository.findByEmail(newStudent.getEmail());
		// TODO testar
		if (otherUser.size() > 0) {
			return ResponseEntity.unprocessableEntity().build();
		}
		Student savedUser = repository.save(newStudent);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}

	// GET para obter um usuário pelo ID
	@GetMapping("/{studentId}")
	public ResponseEntity<Student> getUserById(@PathVariable Long studentId) {
		Optional<Student> user = repository.findById(studentId);

		// Verifica se o usuário com o ID fornecido existe
		if (user.isPresent()) {
			return ResponseEntity.ok(user.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	// GET para obter um usuário pelo ID
	@GetMapping("/email/{email}")
	public ResponseEntity<Student> getUserByEmail(@PathVariable String email) {
		Student user = repository.findByEmail(email).get(0);
		System.out.println(user.toString());

		// Verifica se o usuário com o ID fornecido existe
		if (user.getId() != null) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
