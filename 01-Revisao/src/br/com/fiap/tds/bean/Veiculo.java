package br.com.fiap.tds.bean;

public class Veiculo {
	
	//CTRL + 3 -> ggas (Gerar os gets e sets), gcuf (Gerar construtor)
	
	//Modificadores de acesso:
	//private -> somente a própria classe;
	//public -> todos;
	//protected -> própria classe, classes do mesmo pacote e filhas;
	//default (package) -> própria classe e classes do mesmo pacote;
	private int ano;
	
	private String modelo;
	
	private float peso;
	
	private String cor;
	
	private TipoVeiculo tipo; //gets e sets
	
	//Tipos primitivos: boolean, char, byte, short, int, long, float, double
	//Valores padrão: boolean = false, números = 0;
	
	//Tipos de referencia (classes): String, Veiculo, Date, Carro...
	//Valor padrão: null;
	
	//Construtores -> sem retorno e mesmo nome da classe
	public Veiculo(int ano, String modelo) {
		this.ano = ano;
		this.modelo = modelo;
	}
	
	public Veiculo() {}
	
	//Sobrecarga -> mesmo método com parâmetros diferentes
	public void andar(){
		System.out.println("Veiculo andando...");
	} 
	
	public void andar(float velocidade) {
		System.out.println("Veiculo andando a " + velocidade);
	}
	
	public void andar(float velocidade, boolean turbo) {
		System.out.println("Veiculo andando a " + velocidade + turbo);
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getAno() {
		return ano;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}
	
}