package br.gov.etec.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.SolicitacaoDocumento;

@Repository
public interface SolicitacaoDocumentoRepository extends JpaRepository<SolicitacaoDocumento, Long> {
	
	SolicitacaoDocumento findById(long id);		
	List<SolicitacaoDocumento> findByAluno(Pessoa aluno);
	
}
