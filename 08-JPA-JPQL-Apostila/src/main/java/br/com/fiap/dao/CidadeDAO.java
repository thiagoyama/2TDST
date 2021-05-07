package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cidade;

public interface CidadeDAO extends GenericDAO<Cidade,Integer> {
	
	//Pesquisar por todas as cidades
	List<Cidade> listar();
	
	//Pesquisar cidades por estado
	List<Cidade> buscarPorEstado(String estado);

}
