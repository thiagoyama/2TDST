package br.com.fiap.tds.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FilmeDao;
import br.com.fiap.tds.entity.Filme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FilmeNotFoundException;

public class FilmeDaoImpl implements FilmeDao {

	private EntityManager em;
	
	public FilmeDaoImpl(EntityManager em) {
		this.em = em;
	}
	
	@Override
	public void create(Filme filme) {
		em.persist(filme);
	}

	@Override
	public Filme findById(int id) throws FilmeNotFoundException {
		Filme filme = em.find(Filme.class, id);
		if (filme == null)
			throw new FilmeNotFoundException();
		return filme;
	}

	@Override
	public void update(Filme filme) {
		em.merge(filme);
	}

	@Override
	public void remove(int id) throws FilmeNotFoundException {
		Filme filme = findById(id);
		em.remove(filme);
	}

	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			throw new CommitException();
		}
	}

}
