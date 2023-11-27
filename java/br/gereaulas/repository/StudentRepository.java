package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.Student;
import br.gereaulas.model.Teacher;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByEmail(String email);

}
