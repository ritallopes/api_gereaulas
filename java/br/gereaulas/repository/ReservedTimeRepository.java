package br.gereaulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.ReservedTime;

public interface ReservedTimeRepository extends JpaRepository<ReservedTime, Long> { 
}
