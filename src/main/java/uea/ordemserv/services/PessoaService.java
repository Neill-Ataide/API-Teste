package uea.ordemserv.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.ordemserv.models.Pessoa;
import uea.ordemserv.repositories.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Pessoa criar(Pessoa pessoa) {
		return pessoaRepository.save(pessoa);
	}

	public List<Pessoa> listar() {
		return pessoaRepository.findAll();
	}

	public Pessoa buscarPorCodigo(Long codigo) {
		Pessoa ordemService = pessoaRepository.findById(codigo).orElseThrow();
		return ordemService;

	}

	public void excluir(Long codigo) {
		Optional<Pessoa> pessoaExistente = pessoaRepository.findById(codigo);
	    if(!(pessoaExistente == null)) {
	        throw new RuntimeException("Não existe ninguem com este ID");
	    }
		pessoaRepository.deleteById(codigo);
	}

	public Pessoa atualizar(Long codigo, Pessoa pessoa) {
		Pessoa ordemServiceSalva = pessoaRepository.findById(codigo).orElseThrow();
		BeanUtils.copyProperties(pessoa, ordemServiceSalva, "codigo");
		return pessoaRepository.save(ordemServiceSalva);

	}
}