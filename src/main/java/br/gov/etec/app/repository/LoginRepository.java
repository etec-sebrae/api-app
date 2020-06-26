package br.gov.etec.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	
	Optional<Login> findByEmail(String email);

}
