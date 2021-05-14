package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager entityManager) {
		super(entityManager);
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) {
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.nome like :n", Cliente.class);
		query.setParameter("n", "%" + nome + "%" );
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) {
		TypedQuery<Cliente> query = em.createQuery(
				"from Cliente c where c.endereco.cidade.uf = :es", Cliente.class);
		query.setParameter("es", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorDiasReservas(int dias) {
		return em.createQuery("select r.cliente from Reserva r where r.numeroDias = :pDias", Cliente.class)
				.setParameter("pDias", dias)
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) {
		return em.createQuery("from Cliente c where c.nome like :name and c.endereco.cidade.nome like :city", Cliente.class)
				.setParameter("name", "%" + nome + "%")
				.setParameter("city", "%" + cidade + "%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) {
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :states", Cliente.class)
				.setParameter("states", estados)
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome2(String nome) {
		return em.createQuery("", Cliente.class)
				.setParameter("", nome)
				.getResultList();
	}

}


