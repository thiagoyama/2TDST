package br.com.fiap.tds.dao;

import java.util.List;
import br.com.fiap.tds.bean.Carro;

public interface CarroDao {

	void cadastrar(Carro carro);
	
	List<Carro> listar();
	
}