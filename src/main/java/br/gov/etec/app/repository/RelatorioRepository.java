package br.gov.etec.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.etec.app.entity.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long>{
	
	List<Relatorio>findById(long id);
	
	Relatorio findByIdRelatorio(long id);

}
