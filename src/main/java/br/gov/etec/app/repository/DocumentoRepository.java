package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Documento;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
	
	Documento findById(long id);
	
}
