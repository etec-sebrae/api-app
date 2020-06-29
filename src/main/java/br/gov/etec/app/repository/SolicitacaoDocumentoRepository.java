package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gov.etec.app.entity.SolicitacaoDocumento;

@Repository
public interface SolicitacaoDocumentoRepository extends JpaRepository<SolicitacaoDocumento, Long> {
	
	SolicitacaoDocumento findById(long id);
	
}
