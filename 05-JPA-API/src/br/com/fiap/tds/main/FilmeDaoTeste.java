package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.dao.FilmeDao;
import br.com.fiap.tds.dao.impl.FilmeDaoImpl;
import br.com.fiap.tds.entity.Filme;
import br.com.fiap.tds.entity.GeneroFilme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FilmeNotFoundException;

public class FilmeDaoTeste {

	public static void main(String[] args) {
		//Obter o Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();
		
		//Obter o FilmeDao
		FilmeDao dao = new FilmeDaoImpl(em);
		
		//Cadastrar
		Filme filme = new Filme("Senhor dos aneis", 
				new GregorianCalendar(2000, Calendar.JANUARY, 1), GeneroFilme.AVENTURA, "Teste", false);
		
		try {
			dao.create(filme);
			dao.commit();
			System.out.println("Filme cadastrado!");
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar e exibir os dados
		try {
			filme = dao.findById(3);
			System.out.println(filme.getNome());
		} catch(FilmeNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Atualizar
		filme = new Filme(3, "Mulher Marvilha", Calendar.getInstance(), GeneroFilme.ACAO, "Super mulher", false);
		try {
			dao.update(filme);
			dao.commit();
			System.out.println("Filme atualizado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Remover
		try {
			dao.remove(41);
			dao.commit();
			System.out.println("Filme removido!");
		} catch(FilmeNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
