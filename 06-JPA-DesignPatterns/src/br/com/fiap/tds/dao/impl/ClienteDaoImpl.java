package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ClienteDao;
import br.com.fiap.tds.entity.Cliente;

public class ClienteDaoImpl extends GenericDaoImpl<Cliente, Integer> implements ClienteDao {

	public ClienteDaoImpl(EntityManager em) {
		super(em);
	}

}