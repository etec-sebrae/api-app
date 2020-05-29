package br.gov.etec.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Aluno;
import br.gov.etec.app.repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
	
	@Autowired
	AlunoRepository repository;
	
	@GetMapping("/listar")
	public List<Aluno> listaAlunos(){
		return repository.findAll();
	}
	
	@GetMapping("/{id}")
	public Object listaAluno(@PathVariable("id") Long id){
		return repository.findById(id);
	}
	
	
	@PostMapping("/cadastrar")
	public void cadastraAluno(@RequestBody AlunoDto alunodto) {
		Aluno aluno = this.dtoAluno(alunodto);		
		repository.save(aluno);	
	}
	
	@PostMapping("/logar")
	public Object alunoLogin(@RequestBody AlunoDto alunodto) {
		return repository.findByEmailAndSenha(alunodto.getEmail(), alunodto.getSenha());	
		
	}
	
	public Aluno dtoAluno(AlunoDto aluno) {
		Aluno a = new Aluno();
		a.setNome(aluno.getNome());
		a.setRg(aluno.getRg());
		a.setCpf(aluno.getCpf());
		a.setEmail(aluno.getEmail());
		a.setData_nasc(aluno.getData_nasc());
		a.setId_curso(aluno.getId_curso());
		a.setSenha(aluno.getSenha());		
		return a;		
	}

}
