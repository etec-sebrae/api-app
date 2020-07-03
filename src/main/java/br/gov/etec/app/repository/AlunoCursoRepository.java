package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.AlunoCurso;
import br.gov.etec.app.entity.Pessoa;

public interface AlunoCursoRepository extends JpaRepository<AlunoCurso, Long> {
	AlunoCurso findByAluno(Pessoa aluno);
}
