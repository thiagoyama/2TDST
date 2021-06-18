package br.com.fiap.tds.entity;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//JOINED ou TABLE_PER_CLASS
@Table(name="TB_PESSOA_FISICA")

@Entity
public class PessoaFisica extends Pessoa {

	@Column(name="nr_cpf", length = 13)
	private String cpf;
	
	@Column(name="nr_rg", length = 15)
	private String rg;
	
	public PessoaFisica() {}
	
	//CTRL + 3 -> gcuf
	public PessoaFisica(String nome, Calendar dataRegistro, String cpf, String rg) {
		super(nome, dataRegistro);
		this.cpf = cpf;
		this.rg = rg;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}
	
}