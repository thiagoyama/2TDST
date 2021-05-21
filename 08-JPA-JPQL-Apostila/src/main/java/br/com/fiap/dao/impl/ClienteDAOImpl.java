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

	//Buscar por parte do nome do cliente  sem case sensitive e ordenado por nome
	@Override
	public List<Cliente> buscarPorNome2(String nome) {
		return em.createQuery("from Cliente c where lower(c.nome) like lower(:name) order by c.nome", Cliente.class)
				.setParameter("name", "%" + nome + "%")
				.getResultList();
	}

	@Override
	public long contarPorEstado(String estado) {
		return em.createQuery("select count(c) from Cliente c where c.endereco.cidade.uf = :vaiDarBom", Long.class)
				.setParameter("vaiDarBom", estado)
				.getSingleResult();
	}

}


