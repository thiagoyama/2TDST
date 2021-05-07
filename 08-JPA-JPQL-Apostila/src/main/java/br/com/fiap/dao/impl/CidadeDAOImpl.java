package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade,Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cidade> listar() {
		//Criar a Query
		TypedQuery<Cidade> query = em.createQuery("from Cidade", Cidade.class);
		//Executar a Query
		return query.getResultList();
	}

	@Override
	public List<Cidade> buscarPorEstado(String estado) {
		//Criar a Query
		TypedQuery<Cidade> query = em.createQuery("from Cidade c where c.uf = :es", Cidade.class);
		//Setar o parametro na Query
		query.setParameter("es", estado);
		//Executar a Query
		return query.getResultList();
	}
}
