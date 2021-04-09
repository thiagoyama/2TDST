package br.com.fiap.tds.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Filme;
import br.com.fiap.tds.entity.GeneroFilme;


// View - Controller - DAO - Banco

public class Atualizacao {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Instanciar um filme com um código (Estado detached - não gerenciado)
		Filme filme = new Filme(1, "Vingadores", 
			new GregorianCalendar(2019, Calendar.JULY, 4), 
			GeneroFilme.AVENTURA, "Top", true);
		
		//Retorna a cópia gerenciada do filme
		Filme filmeGerenciado = em.merge(filme);
		
		//filmeGerenciado.setNome("Teste");
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		System.out.println("Filme atualizado!");
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
