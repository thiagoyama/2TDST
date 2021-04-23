package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_FORNECEDOR")
@SequenceGenerator(name="fornecedor", sequenceName = "SQ_TB_FORNECEDOR", allocationSize = 1)
public class Fornecedor {
	
	@Id
	@Column(name="cd_fornecedor")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fornecedor")
	private int codigo;
	
	@Column(name="nm_fornecedor", nullable = false, length = 40)
	private String nome;
	
	@Column(name="nr_telefone", nullable = false, length = 20)
	private String telefone;
	
	@Column(name="ds_email", length = 60)
	private String email;
	
	//Mapeamento do relacionamento muitos-para-muitos bidirecional
	@ManyToMany(mappedBy = "fornecedores")
	private List<Padaria> padarias;
	
	public Fornecedor() {}
	
	public Fornecedor(String nome, String telefone, String email) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
	}

	public Fornecedor(int codigo, String nome, String telefone, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Padaria> getPadarias() {
		return padarias;
	}

	public void setPadarias(List<Padaria> padarias) {
		this.padarias = padarias;
	}
	
}
