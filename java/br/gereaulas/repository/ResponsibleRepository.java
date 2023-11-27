package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.Responsible;
import br.gereaulas.model.Student;
import br.gereaulas.model.Teacher;

public interface ResponsibleRepository extends JpaRepository<Responsible, Long> {
	List<Responsible> findByEmail(String email);

}
