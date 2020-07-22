package br.gov.etec.app.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.AlunoDto;
import br.gov.etec.app.entity.Curso;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.TipoEnum;
import br.gov.etec.app.repository.PessoaRepository;

@Service
public class AlunoService {
	@Autowired
	private PessoaRepository pessoaAlunoRepository;
						
	@Autowired
	private UsuarioService usuarioService;	
	
	@Autowired
	private CursoService cursoService;
		
		
	public List<Pessoa> listar(Pageable pageable){				
		List<Pessoa> aluno = pessoaAlunoRepository.findByTipo(TipoEnum.ALUNO);
		pessoaAlunoRepository.flush();				
		return aluno;
	}
	
	public Pessoa cadastrar(AlunoDto alunoDto){
									
		Pessoa aluno = alunoDto.transformaAlunoDto();	
		
		List<Curso> listaCurso = new ArrayList<>();		
		for(int i = 0; i < alunoDto.getCursos().size();i++) {			
			long id = alunoDto.getCursos().get(i).getId();			
			Curso curso = cursoService.buscarPorId(id);			
			listaCurso.add(curso);			
		}		
		aluno.setCursos(listaCurso);
		
		Pessoa alunoData = pessoaAlunoRepository.save(aluno);
		pessoaAlunoRepository.flush();
		
		Usuario usuario = usuarioService.criarUsuarioAluno(alunoDto.getEmail(),alunoDto.getSenha());		
		alunoData.setUsuario(usuario);
			
		pessoaAlunoRepository.save(aluno);	
		pessoaAlunoRepository.flush();
		
		return aluno;			
	}
		
	public Pessoa buscarPorId(long id){
		Pessoa aluno = pessoaAlunoRepository.findById(id);
		pessoaAlunoRepository.flush();
		return aluno;
	}
		
	
	
	public Pessoa atualizar(long id, AlunoDto dto){
		Pessoa aluno = pessoaAlunoRepository.findById(id);
		pessoaAlunoRepository.flush();
		
		if(dto.getCpf() != "") {
			if (aluno.getCpf() != dto.getCpf()) {
				aluno.setCpf(dto.getCpf());
			}
		}
		
		if(dto.getData_nasc() != null) {
			if (aluno.getData_nasc() != dto.getData_nasc()) {
				aluno.setData_nasc(dto.getData_nasc());
			}
		}
		
		if(dto.getEmail() != "") {
			if(aluno.getUsuario().getEmail() != dto.getEmail()) {
				aluno.setEmail(dto.getEmail());
				aluno.getUsuario().setEmail(dto.getEmail());
			}
		}
	
		if(dto.getMatricula() != 0L) {
			if(aluno.getMatricula() != dto.getMatricula()) {
				aluno.setMatricula(dto.getMatricula());
			}
		}
		
		if(dto.getNome() != "") {
			if(aluno.getNome() != dto.getNome()) {
				aluno.setNome(dto.getNome());
			}
		}
		
		if(dto.getRg() != "") {
			if(aluno.getRg() != dto.getRg()) {
				aluno.setRg(dto.getRg());
			}
		}
		
		Pessoa _aluno = pessoaAlunoRepository.save(aluno);
		pessoaAlunoRepository.flush();
		
		return _aluno;
		
		
	}
	
}
