package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente,Integer> {

	//2 - Pesquisar por parte do nome
	List<Cliente> buscarPorNome(String nome);
	
	//4 - Pesquisar por estado
	List<Cliente> buscarPorEstado(String estado);
	
	//5 - Pesquisar por quantidade de dias reserva
	List<Cliente> buscarPorDiasReservas(int dias);
	
	//7 - Pesquisar por parte do nome e parte do nome da cidade
	List<Cliente> buscar(String nome, String cidade);
	
	//8 - Pesquisar por estados
	List<Cliente> buscarPorEstados(List<String> estados);
	
	//Pesquisar por parte do nome, sem diferenciar as maiúsculas e minúsculas ordenado pelo nome
	List<Cliente> buscarPorNome2(String nome);
	
	//Contar a quantidade de cliente por estado
	long contarPorEstado(String estado);
}



