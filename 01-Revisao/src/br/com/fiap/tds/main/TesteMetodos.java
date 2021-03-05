package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Carro;
import br.com.fiap.tds.bean.Veiculo;

public class TesteMetodos {

	//main -> CTRL + Espaço
	public static void main(String[] args) {
		
		//Instanciar um veiculo
		Veiculo veiculo = new Veiculo();
		
		//Chamar o método andar() do veículo
		veiculo.andar(); // Veiculo
		
		//Instanciar um carro
		Carro carro = new Carro();
		
		//Chamar o método andar() do carro
		carro.andar(); // Carro
		
		Veiculo v = new Carro();
		v.andar(); // Carro
		
		//Carro c = new Veiculo(); //Não compila!
		
	}
	
}
