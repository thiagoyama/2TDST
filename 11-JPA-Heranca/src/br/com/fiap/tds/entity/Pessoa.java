package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Inheritance(strategy = InheritanceType.JOINED)

//SINGLE_TABLE
//Renomear a coluna que armazena o tipo de objeto gravado
//@DiscriminatorColumn(name="ds_tipo")

//Altera o valor que é gravado no banco, ao invés do nome da classe
//@DiscriminatorValue("P")

@Entity
@Table(name="TB_PESSOA")
@SequenceGenerator(name="pessoa", sequenceName = "SQ_TB_PESSOA", allocationSize = 1)
public class Pessoa {
	
	@Id
	@Column(name="cd_pessoa")
	@GeneratedValue(generator = "pessoa", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_pessoa", nullable = false, length = 80)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_registro")
	private Calendar dataRegistro;
	
	public Pessoa() {}

	public Pessoa(String nome, Calendar dataRegistro) {
		this.nome = nome;
		this.dataRegistro = dataRegistro;
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

	public Calendar getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
}
