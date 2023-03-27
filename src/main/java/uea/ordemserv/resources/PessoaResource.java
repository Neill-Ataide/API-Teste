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

import uea.ordemserv.models.Pessoa;
import uea.ordemserv.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.criar(pessoa);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codigo}")
				.buildAndExpand(pessoaSalva.getCodigo()).toUri();

		return ResponseEntity.created(uri).body(pessoaSalva);
	}

	@GetMapping
	public ResponseEntity<List<Pessoa>> listar() {
		List<Pessoa> pessoaes = pessoaService.listar();
		return ResponseEntity.ok().body(pessoaes);
	}

	@GetMapping(value = "/{codigo}")
	public ResponseEntity<Pessoa> buscarPorCodigo(@PathVariable Long codigo) {
		Pessoa pessoaes = pessoaService.buscarPorCodigo(codigo);
		return ResponseEntity.ok().body(pessoaes);
	}

	@DeleteMapping(value = "/{codigo}")
	public ResponseEntity<Void> excluir(@PathVariable Long codigo) {
		pessoaService.excluir(codigo);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value = "/{codigo}")
	public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo,@RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = pessoaService.atualizar(codigo, pessoa);
		return ResponseEntity.ok().body(pessoaSalva);

	}
}