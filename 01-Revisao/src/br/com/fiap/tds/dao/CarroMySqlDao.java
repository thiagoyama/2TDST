package br.com.fiap.tds.dao;

import java.util.List;
import br.com.fiap.tds.bean.Carro;

public class CarroMySqlDao implements CarroDao {

	@Override
	public void cadastrar(Carro carro) {
		System.out.println("Cadastrando no mysql");
	}

	@Override
	public List<Carro> listar() {
		System.out.println("Listando do mysql");
		return null;
	}

}
