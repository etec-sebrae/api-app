package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.SolicitacaoDocumento;

public interface SolicitacaoDocumentoRepository extends JpaRepository<SolicitacaoDocumento, Long> {
	
	SolicitacaoDocumento findById(long id);

}
