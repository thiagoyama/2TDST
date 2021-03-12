package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.TipoVeiculo;
import br.com.fiap.tds.bean.Veiculo;

public class TesteEnum {

	public static void main(String[] args) {
		//Instanciar um veiculo
		Veiculo veiculo = new Veiculo(2019, "Hb20");
		
		//Atribuir um tipo de veiculo
		veiculo.setTipo(TipoVeiculo.TERRESTRE);
		
		//Validar se o veiculo é do tipo terrestre
		if (veiculo.getTipo() == TipoVeiculo.TERRESTRE) {
			System.out.println("Veiculo é terrestre");
		}
		
		//Exibir o tipo de veiculo
		System.out.println(veiculo.getTipo());
	}
	
}
