package br.com.fiap.tds.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_PEDIDO")
@SequenceGenerator(name="pedido", sequenceName = "SQ_TB_PEDIDO", 
															allocationSize = 1)
//name -> nome no Java, utilizado no GeneratedValue
//sequenceName -> nome da sequence no banco de dados
//allocationSize -> incremento
public class Pedido {

	@Id
	@Column(name="cd_pedido")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pedido")
	private int codigo;
	
	@Column(name="ds_pedido", length = 60)
	private String descricao;
	
	@Column(name="dt_pedido", nullable = false, updatable = false)
	private Calendar data;
	
	@Column(name="nm_cliente", nullable = false, length = 100)
	private String cliente;
	
	@Column(name="vl_pedido")
	private double valor;
	
}
