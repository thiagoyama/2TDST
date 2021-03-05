package br.com.fiap.tds.bean;

public class Carro extends Veiculo {

	//Construtor é herdado? NÃO!
	public Carro(int ano, String modelo) {
		super(ano, modelo);
	}
	
	public Carro() {}
	
	//Sobrescrita -> o mesmo método da classe pai na classe filha
	@Override
	public void andar() {
		System.out.println("Carro andando..");
	}
	
}