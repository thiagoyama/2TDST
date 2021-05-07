package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma CidadeDao
		CidadeDAO cidadeDao = new CidadeDAOImpl(em);
		
		//Exibir todas as cidades 
		List<Cidade> cidades = cidadeDao.listar();
		System.out.println("Listar todas as cidades");
		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}
		
		//Pesquisar as cidades por Estado
		cidades = cidadeDao.buscarPorEstado("SP");
		System.out.println("Buscar cidade por estado");
		cidades.forEach(c -> System.out.println(c.getNome() + " - " + c.getUf()));
		
		//Instanciar o ClienteDAO
		ClienteDAO clienteDao = new ClienteDAOImpl(em);
		
		//Listar todos os clientes
		List<Cliente> clientes = clienteDao.listar();
		System.out.println("Listar todos os clientes");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Pesquisar cliente por parte do nome
		clientes = clienteDao.buscarPorNome("Pa");
		System.out.println("Buscar clientes por parte do nome");
		clientes.forEach(c -> System.out.println(c.getNome()));
		
		//Instanciar um PacoteDAO e TransporteDAO
		PacoteDAO pacoteDao = new PacoteDAOImpl(em);
		TransporteDAO transporteDao = new TransporteDAOImpl(em);
		
		//Pesquisar um transporte por id
		Transporte transporte = transporteDao.pesquisar(2);
		
		//Pesquisar pacotes por transporte
		List<Pacote> pacotes = pacoteDao.buscarPorTransporte(transporte);
		System.out.println("Buscar pacotes por transporte");
		pacotes.forEach(p -> System.out.println(p.getDescricao() + " " + p.getTransporte().getEmpresa()));
		
		//Pesquisar cliente por estado
		clientes = clienteDao.buscarPorEstado("BA");
		System.out.println("Buscar clientes por estado");
		clientes.forEach(c -> System.out.println(c.getNome() + " " + c.getEndereco().getCidade().getUf()));
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}

