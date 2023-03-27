package uea.ordemserv.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Pessoa implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nome;
	private String telefone;

	@JsonIgnoreProperties("solicitante")
	@OneToMany(mappedBy = "solicitante")
	private List<OrdemServico> ordens = new ArrayList<>();

	public Pessoa() {

	}

	public Pessoa(Long codigo, String nome, String telefone, List<OrdemServico> ordens) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.ordens = ordens;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<OrdemServico> getOrdens() {
		return ordens;
	}

	public void setOrdens(List<OrdemServico> ordens) {
		this.ordens = ordens;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
