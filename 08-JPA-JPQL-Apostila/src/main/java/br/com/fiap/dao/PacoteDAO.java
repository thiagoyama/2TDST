package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer> {
	
	//3 - Pesquisar por Transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);

	//Pesquisar por preco menor, retornando somente a descrição e quantidade de dias (List<Object[]>)
	List<Object[]> buscarPorPrecoMenor(float preco);
	
	//Pesquisar por preco menor, retornando somente a descrição e quantidade de dias (List<Pacote>)
	List<Pacote> buscarPorPrecoMenor2(float preco);
	
	//Pesquisar por preço menor, retornando somente a descrição (List<String>)
	List<String> buscarPorPrecoMenor3(float preco);
	
	//6 - Buscar pacotes por data de saída
	List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim);
	
}
