package br.com.fiap.tds.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PRODUTO")
@SequenceGenerator(name="produto", sequenceName = "SQ_TB_PRODUTO", allocationSize = 1)
public class Produto {
	
	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto")
	private int codigo;
	
	@Column(name="nm_produto", nullable = false, length = 80)
	private String nome;
	
	@Column(name="ds_produto", nullable = false, length = 200)
	private String descricao;
	
	@Column(name="vl_produto")
	private Double valor;
	
	//Relacionamento muitos-para-um
	@ManyToOne
	@JoinColumn(name="cd_padaria", nullable = false)
	private Padaria padaria;
	
	public Produto() {}

	public Produto(String nome, String descricao, Double valor) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public Produto(int codigo, String nome, String descricao, Double valor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Padaria getPadaria() {
		return padaria;
	}

	public void setPadaria(Padaria padaria) {
		this.padaria = padaria;
	}
	
}
