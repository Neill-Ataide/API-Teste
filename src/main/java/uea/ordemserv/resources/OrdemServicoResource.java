package uea.ordemserv.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.ordemserv.models.OrdemServico;
import uea.ordemserv.services.OrdemServicoService;

@RestController
@RequestMapping("/ordens")
public class OrdemServicoResource {
	
	@Autowired
	private OrdemServicoService ordemServicoService;

	@PostMapping
	public ResponseEntity<OrdemServico> criar(@RequestBody OrdemServico ordemServico) {
		OrdemServico ordemServicoSalva = ordemServicoService.criar(ordemServico);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(ordemServicoSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(ordemServicoSalva);
	}

	@GetMapping
	public ResponseEntity<List<OrdemServico>> listar() {
		List<OrdemServico> ordemServicoes = ordemServicoService.listar();
		return ResponseEntity.ok().body(ordemServicoes);
	}

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<OrdemServico> buscarPorCodigo(@PathVariable Long codigo) {
		OrdemServico ordemServicoes = ordemServicoService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(ordemServicoes);
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		ordemServicoService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<OrdemServico> atualizar(@PathVariable Long codigo,@RequestBody OrdemServico ordemServico) {
		OrdemServico ordemServicoSalva = ordemServicoService.atualizar(codigo, ordemServico);
		return ResponseEntity.ok().body(ordemServicoSalva);

	}
}