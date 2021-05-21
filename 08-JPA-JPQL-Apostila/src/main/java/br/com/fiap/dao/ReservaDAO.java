package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Reserva;

public interface ReservaDAO extends GenericDAO<Reserva,Integer>{

	//Buscar reserva por cpf
	List<Reserva> buscarPorCpfCliente(String cpf);
	
	//Buscar por parte do nome da empresa de transporte
	List<Reserva> buscarPorEmpresaTransporte(String empresa);
	
}
