package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PADARIA")
@SequenceGenerator(name="padaria", sequenceName = "SQ_TB_PADARIA", allocationSize = 1)
public class Padaria {
	
	@Id
	@Column(name="cd_padaria")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "padaria")
	private int codigo;
	
	@Column(name="nm_padaria", nullable = false, length = 80)
	private String nome;
	
	@Column(name="vl_faturamento")
	private Double faturamento;
	
	@Column(name="ds_horario", length = 100)
	private String horarioFuncionamento;
	
	public Padaria() {}

	public Padaria(String nome, Double faturamento, String horarioFuncionamento) {
		super();
		this.nome = nome;
		this.faturamento = faturamento;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public Padaria(int codigo, String nome, Double faturamento, String horarioFuncionamento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.faturamento = faturamento;
		this.horarioFuncionamento = horarioFuncionamento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}

	public String getHorarioFuncionamento() {
		return horarioFuncionamento;
	}

	public void setHorarioFuncionamento(String horarioFuncionamento) {
		this.horarioFuncionamento = horarioFuncionamento;
	}
	
}
