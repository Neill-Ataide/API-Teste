package uea.ordemserv.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.ordemserv.models.OrdemServico;
import uea.ordemserv.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository ordemServicoRepository;

	public OrdemServico criar(OrdemServico ordemServico) {
		return ordemServicoRepository.save(ordemServico);
	}

	public List<OrdemServico> listar() {
		return ordemServicoRepository.findAll();
	}

	public OrdemServico buscarPorCodigo(Long codigo) {
		OrdemServico ordemService = ordemServicoRepository.findById(codigo).orElseThrow();
		return ordemService;

	}

	public void excluir(Long codigo) {
		ordemServicoRepository.deleteById(codigo);
	}

	public OrdemServico atualizar(Long codigo, OrdemServico ordemServico) {
		OrdemServico ordemServiceSalva = ordemServicoRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(ordemServico, ordemServiceSalva, "codigo");
		return ordemServicoRepository.save(ordemServiceSalva);

	}
}