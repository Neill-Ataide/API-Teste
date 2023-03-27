package uea.ordemserv.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import uea.ordemserv.models.OrdemServico;


@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
	
}
