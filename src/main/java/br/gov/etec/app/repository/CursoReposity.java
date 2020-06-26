package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Curso;

public interface CursoReposity extends JpaRepository<Curso,Long> {
	Curso findById(long id);
}
