package br.com.fiap.tds.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.tds.entity.Filme;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter a fabrica e o entity manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("oracle");
		EntityManager em = fabrica.createEntityManager();

		//Pesquisar o filme de código 1 
		//Retornar o objeto gerenciado ou null, caso não encontre
		Filme filme = em.find(Filme.class, 1);
		
		if (filme != null)
			//Exibir o nome do filme
			System.out.println(filme.getNome());
		else
			System.out.println("Filme não encontrado");
		
//		filme.setPremiado(true);
//		
//		em.getTransaction().begin();
//		em.getTransaction().commit();
		
		//Fechar
		em.close();
		fabrica.close();
	}
	
}
