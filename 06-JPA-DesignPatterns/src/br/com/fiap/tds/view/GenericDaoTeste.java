package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import br.com.fiap.tds.dao.ClienteDao;
import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.impl.ClienteDaoImpl;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.entity.Cliente;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class GenericDaoTeste {

	public static void main(String[] args) {
		
		//Obter o entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter um clienteDao
		//ClienteDao dao = new ClienteDaoImpl(em);
		
		//Instanciar uma classe anonima
		//Definir uma classe que é filha da GenericDaoImpl e obter a instância
		GenericDao<Cliente, Integer> dao = new GenericDaoImpl<Cliente, Integer>(em) {};
		
		//Cadastrar
		Cliente cliente = new Cliente("Allan", "allan@fiap.com.br",
								new GregorianCalendar(2001, Calendar.JANUARY, 1));
		
		try {
			dao.create(cliente);
			dao.commit();
			System.out.println("Cliente cadastrado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pequisar e exibir o nome
		try {
			cliente = dao.findById(1);
			System.out.println(cliente.getNome());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar
		cliente = new Cliente(1, "João", "joao@fiap.com.br", 
									new GregorianCalendar(2001, Calendar.JULY, 8));
		
		try {
			dao.update(cliente);
			dao.commit();
			System.out.println("Cliente atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.delete(1);
			dao.commit();
			System.out.println("Cliente removido!");
		} catch (CommitException | EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe
