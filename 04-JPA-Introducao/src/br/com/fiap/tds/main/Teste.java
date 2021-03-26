package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		//Fabrica de gerenciador de entidades
		EntityManagerFactory fabrica = 
				Persistence.createEntityManagerFactory("oracle");
				
		//Gerenciador de entidades (EntityManager)
		EntityManager em = fabrica.createEntityManager();
		
		//Fechar
		em.close();
		fabrica.close();
		
	}
	
}
