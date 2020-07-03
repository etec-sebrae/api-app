package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Escola;

public interface EscolaRepository extends JpaRepository<Escola, Long> {

}
