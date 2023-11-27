package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
	List<Teacher> findByEmail(String email);
}
