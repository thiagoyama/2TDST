package br.com.fiap.tds.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="end", sequenceName = "SQ_TB_ENDERECO", allocationSize = 1)
public class Endereco {
	
	@Id
	@Column(name="cd_endereco")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "end")
	private int codigo;
	
	@Column(name="ds_logradouro", nullable = false, length = 100)
	private String logradouro;
	
	@Column(name="nr_endereco", length = 10, nullable = false)
	private String numero;
	
	@Column(name="ds_bairro", length = 40)
	private String bairro;
	
	//Mapear a relação um-para-um bidirecional
	//mappedBy -> sempre utilizado no bidirecional
	//mappedBy -> nome do atributo que mapeia a relaçao no banco
	@OneToOne(mappedBy = "endereco", cascade = CascadeType.ALL)
	private Padaria padoca;
	 
	public Endereco() {}

	public Endereco(String logradouro, String numero, String bairro) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
	}
	
	public Endereco(int codigo, String logradouro, String numero, String bairro) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Padaria getPadoca() {
		return padoca;
	}

	public void setPadoca(Padaria padoca) {
		this.padoca = padoca;
	}
	
}
