package br.com.fiap.tds.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TAB_USUARIO")
@SequenceGenerator(name="usuario", sequenceName = "SQ_TAB_USUARIO", allocationSize = 1)
public class Usuario {
	
	@Id
	@Column(name="cod_usuario")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario")
	private int codigo;
	
	@Column(name="nom_usuario")
	private String nome;
	
	@ManyToMany
	@JoinTable(name="TAB_ITEM_TESTE_USUARIO",
			joinColumns = @JoinColumn(name="cod_usuario"),
			inverseJoinColumns = @JoinColumn(name="cod_item_teste"))
	private List<ItemTeste> itensTeste;
	
	public Usuario() {}
	
	public Usuario(String nome, List<ItemTeste> itens) {
		this.nome = nome;
		this.itensTeste = itens;
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

	public List<ItemTeste> getItensTeste() {
		return itensTeste;
	}

	public void setItensTeste(List<ItemTeste> itensTeste) {
		this.itensTeste = itensTeste;
	}
	
}
