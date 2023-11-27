package br.gereaulas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gereaulas.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findByEmail(String email);

	User findByEmailAndPassword(String email, String password);
}
