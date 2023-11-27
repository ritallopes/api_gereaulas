package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.ClassSchedule;
import br.gereaulas.model.User;

public interface ClassScheduleRepository extends JpaRepository<ClassSchedule, Long> {
	List<ClassSchedule> findByTeacherId(Long idTeacher);

}
