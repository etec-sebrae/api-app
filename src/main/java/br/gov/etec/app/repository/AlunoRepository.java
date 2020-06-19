package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.etec.app.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
	
	Aluno findById(long id);
	
	Aluno findByEmailAndSenha(String email, String senha);
	

}
