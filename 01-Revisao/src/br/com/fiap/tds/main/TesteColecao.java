package br.com.fiap.tds.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.fiap.tds.bean.Carro;

public class TesteColecao {
	
	public static void main(String[] args) {
		//Instanciar uma lista de Carro
		List<Carro> lista = new ArrayList<>();
		
		//Adicionar dois carros na lista
		lista.add(new Carro(2020, "Uno"));
		
		Carro carro = new Carro(2010, "Fusca");
		lista.add(carro);
		
		//Exibir os carros da lista
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getAno() + " "
					+ lista.get(i).getModelo());
		}
		
		//foreach
		for (Carro c : lista) {
			System.out.println(c);
			//System.out.println(c.getAno() + " " + c.getModelo());
		}
		
		lista.forEach(c -> System.out.println(c.getAno()
										+ " " + c.getModelo()));
		
		//Mapa
		Map<String,Carro> mapa = new HashMap<String,Carro>();
		
		//adicionar 2 carros no mapa
		mapa.put("v1", new Carro(2021, "Golf"));
		mapa.put("v2", new Carro(2019, "Porshe"));
		
		//Recuperar o carro com a chave "v1"
		carro = mapa.get("v2");
		
		System.out.println(carro.getAno() + " " + carro.getModelo());
		
	}//main

}//classe