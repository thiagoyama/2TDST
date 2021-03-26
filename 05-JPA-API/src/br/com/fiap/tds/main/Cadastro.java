package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Filme;
import br.com.fiap.tds.entity.GeneroFilme;

public class Cadastro {

	public static void main(String[] args) {
		
		//Obter uma fabrica e um entity manager
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
		
		EntityManager em = fabrica.createEntityManager();
		
		//Instanciar um Filme sem o código (Estado novo - não gerenciado)
		Filme filme = new Filme("De volta para o futuro", 
				new GregorianCalendar(1985, Calendar.JANUARY, 7),
				GeneroFilme.FICCAO, "O cara viaja no tempo", false);
		
		//cadastro -> passa o filme para o entity manager gerenciar
		em.persist(filme);
		
		//começar uma transação
		em.getTransaction().begin();
		//commit
		em.getTransaction().commit();
		
//		filme.setGenero(GeneroFilme.AVENTURA);
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		System.out.println("Filme cadastrado!");
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
