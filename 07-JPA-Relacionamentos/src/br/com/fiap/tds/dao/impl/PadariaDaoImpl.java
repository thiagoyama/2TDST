package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.PadariaDao;
import br.com.fiap.tds.entity.Padaria;

public class PadariaDaoImpl 
					extends GenericDaoImpl<Padaria, Integer> implements PadariaDao{

	public PadariaDaoImpl(EntityManager em) {
		super(em);
	}

}
