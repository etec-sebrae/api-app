package br.gov.etec.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.enuns.TipoEnum;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	Pessoa findById(long id);
	List<Pessoa> findByTipo(TipoEnum tipo);
	Pessoa findByEmail(String email);
}
