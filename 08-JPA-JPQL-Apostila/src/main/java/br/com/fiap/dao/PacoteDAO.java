package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public interface PacoteDAO extends GenericDAO<Pacote,Integer> {
	
	//3 - Pesquisar por Transporte
	List<Pacote> buscarPorTransporte(Transporte transporte);

}
