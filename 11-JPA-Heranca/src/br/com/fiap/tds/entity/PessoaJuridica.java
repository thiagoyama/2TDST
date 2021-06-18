package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

//SINGLE_TABLE
//@DiscriminatorValue("PJ")

//JOINED ou TABLE_PER_CLASS
@Table(name="TB_PESSOA_JURIDICA")

@PrimaryKeyJoinColumn(name="cd_pessoa_juridica")

@Entity
public class PessoaJuridica extends Pessoa {

	@Column(name="nr_cnpj", length = 22)
	private String cnpj;
	
	@Column(name="vl_faturamento")
	private Double faturamento;
	
	public PessoaJuridica() {}
	
	public PessoaJuridica(String nome, Calendar dataRegistro, String cnpj, Double faturamento) {
		super(nome, dataRegistro);
		this.cnpj = cnpj;
		this.faturamento = faturamento;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(Double faturamento) {
		this.faturamento = faturamento;
	}
	
	
}
