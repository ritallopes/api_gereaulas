package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.ClassSchedule;
import br.gereaulas.model.ReservedTime;

public interface ReservedTimeRepository extends JpaRepository<ReservedTime, Long> { 
	List<ReservedTime> findByTeacherId(Long idTeacher);
}
