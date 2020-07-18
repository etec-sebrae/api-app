package br.gov.etec.app.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.FuncionarioDto;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Usuario;
import br.gov.etec.app.enuns.PerfilEnum;
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
	
	public Pessoa cadastrar(FuncionarioDto funcionarioDto){
		PerfilEnum perfil;
		
		if(funcionarioDto.getPerfil() == "ADMIN") {
			perfil = PerfilEnum.ROLE_ADMIN;
		}else{
			perfil = PerfilEnum.ROLE_USUARIO;
		}
						
		Pessoa funcionario = pessoaFuncionarioRepository.saveAndFlush(funcionarioDto.tranformaFuncionarioDto());
		
		Usuario usuario = usuarioService.criarUsuarioFuncionario(funcionarioDto.getEmail(),funcionarioDto.getSenha(),perfil);	
		
		funcionario.setUsuario(usuario);	
		
		pessoaFuncionarioRepository.saveAndFlush(funcionario);
		
		return funcionario;
	}
	
	
}
