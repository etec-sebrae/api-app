package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Funcionario;


public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	
}
