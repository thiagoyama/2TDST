package br.com.fiap.tds.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
	
	//Mapeamento da relação um-para-um
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="cd_endereco", nullable = false)
	private Endereco endereco;
	
	//Mapeamento do relacionamento muitos-para-muitos
	@ManyToMany(cascade = CascadeType.PERSIST)
	//JoinTable -> configura a tabela associativa
	//name -> nome da tabela associativa
	//joinColumns -> configura a PK/FK que armazena o código da classe atual (Padaria)
	//inverseJoinColumns -> configura a PK/FK que armazena o código da classe da relação
	@JoinTable(name="TB_PADARIA_FORNECEDOR", 
			joinColumns = @JoinColumn(name="cd_padaria"),
			inverseJoinColumns = @JoinColumn(name="cd_fornecedor"))
	private List<Fornecedor> fornecedores;
	
	//Mapeamento bidirecional um-para-muitos
	@OneToMany(mappedBy = "padaria", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Produto> produtos;
	
	//Método para adicionar produtos (utilizado somente no um-para-muitos)
	//Utilizado para persistir em cascata, para garantir o preenchimento da FK
	public void addProduto(Produto produto) {
		if (produtos == null)
			produtos = new ArrayList<>();
		//Adicionar o produto na lista
		produtos.add(produto);
		//Setar a padaria do produto
		produto.setPadaria(this); //this -> o próprio objeto padaria
	}
	
	public Padaria() {}

	public Padaria(String nome, Double faturamento, String horarioFuncionamento, Endereco endereco) {
		super();
		this.nome = nome;
		this.faturamento = faturamento;
		this.horarioFuncionamento = horarioFuncionamento;
		this.endereco = endereco;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
	
}
