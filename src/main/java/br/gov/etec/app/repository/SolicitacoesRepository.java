package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Solicitacoes;

public interface SolicitacoesRepository extends JpaRepository<Solicitacoes, Long> {
	
	Solicitacoes findById(long id);

}
