package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SecondaryTable(name="TB_FUNCIONARIO_FINANCEIRO",
		//Modifica o nome da PK/FK da tabela secundária
		pkJoinColumns = @PrimaryKeyJoinColumn(name="cd_funcionario_financeiro"))

@Entity
@Table(name="TB_FUNCIONARIO")
@SequenceGenerator(name="func", sequenceName = "SQ_TB_FUNCIONARIO", allocationSize = 1)
public class Funcionario {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator = "func", strategy = GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario", length = 80, nullable = false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_admissao")
	private Calendar dataAdmissao;
	
	@Column(name="vl_salario", nullable = false, table = "TB_FUNCIONARIO_FINANCEIRO")
	private Double salario;
	
	@Column(name="nr_conta", nullable = false, table = "TB_FUNCIONARIO_FINANCEIRO")
	private Integer numeroConta;
	
	@Column(name="nr_agencia", nullable = false, table = "TB_FUNCIONARIO_FINANCEIRO")
	private Integer numeroAgencia;
	
	public Funcionario() {}

	public Funcionario(String nome, Calendar dataAdmissao, Double salario, Integer numeroConta, Integer numeroAgencia) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
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

	public Calendar getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Calendar dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
	
}
