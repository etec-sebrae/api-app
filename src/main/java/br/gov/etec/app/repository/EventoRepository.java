package br.gov.etec.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.gov.etec.app.entity.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {
	

}
