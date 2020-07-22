package br.gov.etec.app.services;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import br.gov.etec.app.dtos.RelatorioDto;
import br.gov.etec.app.entity.Pessoa;
import br.gov.etec.app.entity.Relatorio;
import br.gov.etec.app.repository.RelatorioRepository;

@Service
public class RelatorioService {
	
	@Autowired
	private RelatorioRepository repositoryRelatorio;
	
	@Autowired
	private AlunoService alunoService;
	
	
	public Page<Relatorio> listar(Pageable pageable){	
		Page<Relatorio> relatorios = repositoryRelatorio.findAll(pageable); 
		repositoryRelatorio.flush();
        return relatorios;
    }
	

	public Relatorio cadastrar(RelatorioDto dto){
		Pessoa aluno = alunoService.buscarPorId(dto.getId_aluno());	
		Relatorio relatorio = repositoryRelatorio.save(dto.transformaRelatorioDto(aluno));	
		repositoryRelatorio.flush();
		return relatorio;		
	}
	
	public Relatorio atualizar(long id_relatorio, RelatorioDto dto){		
		Relatorio RelatorioStatus = repositoryRelatorio.findByIdRelatorio(id_relatorio);
		repositoryRelatorio.flush();
		if(RelatorioStatus == null) {
			LinkedHashMap<String, Object> al = new LinkedHashMap<>();
			al.put("defaultMessage", "Relatorio não localizado");
			return null;
		}		
		if(dto.getStatus() != 0L) {
			RelatorioStatus.setStatus((int)dto.getStatus());
		}		
		Relatorio _status = repositoryRelatorio.save(RelatorioStatus);	
		repositoryRelatorio.flush();
		return _status;		
	}
	
	public List<Relatorio> buscarPorId(long id){
		List<Relatorio> relatorios = repositoryRelatorio.findById(id);
		repositoryRelatorio.flush();
		return relatorios;
	}
	
	
	
	
	

}
