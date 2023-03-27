package uea.ordemserv.models;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import uea.ordemserv.models.enums.StatusOrdemServico;

@Entity
public class OrdemServico {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String descricao;
	private StatusOrdemServico stauts;
	private LocalDateTime dataSolicitacao;
	private LocalDateTime dataFinalizado;
	private String servicoRealizado;

	public OrdemServico() {
	}

	public OrdemServico(Long codigo, String descricao, StatusOrdemServico stauts, LocalDateTime dataSolicitacao,
			LocalDateTime dataFinalizado, String servicoRealizado) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.stauts = stauts;
		this.dataSolicitacao = dataSolicitacao;
		this.dataFinalizado = dataFinalizado;
		this.servicoRealizado = servicoRealizado;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public StatusOrdemServico getStauts() {
		return stauts;
	}

	public void setStauts(StatusOrdemServico stauts) {
		this.stauts = stauts;
	}

	public LocalDateTime getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public LocalDateTime getDataFinalizado() {
		return dataFinalizado;
	}

	public void setDataFinalizado(LocalDateTime dataFinalizado) {
		this.dataFinalizado = dataFinalizado;
	}

	public String getServicoRealizado() {
		return servicoRealizado;
	}

	public void setServicoRealizado(String servicoRealizado) {
		this.servicoRealizado = servicoRealizado;
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
		OrdemServico other = (OrdemServico) obj;
		return Objects.equals(codigo, other.codigo);
	}

}
