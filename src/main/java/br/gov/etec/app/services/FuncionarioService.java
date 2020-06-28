package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.TipoEnum;
import br.gov.etec.app.repository.PessoaRepository;

@Service
public class FuncionarioService {
	@Autowired
	private PessoaRepository pessoaFuncionarioRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	public List<Pessoa> listar(){
		List<Pessoa> pessoaFuncionario = pessoaFuncionarioRepository.findByTipo(TipoEnum.FUNCIONARIO);
		pessoaFuncionarioRepository.flush();		
		return pessoaFuncionario;	
	}
	
	public Pessoa cadastrar(FuncionarioDto funcionarioDto,  BindingResult result){
		if(result.hasErrors()) {
			return null;
		}
		
		Usuario usuario = usuarioService.criarUsuarioAluno(funcionarioDto.getEmail(),funcionarioDto.getSenha());
		Pessoa funcionario = pessoaFuncionarioRepository.save(funcionarioDto.tranformaFuncionarioDto(usuario));		
				
		return funcionario;
	}
	
	
}
