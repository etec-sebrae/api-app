package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findById(long id);
}
