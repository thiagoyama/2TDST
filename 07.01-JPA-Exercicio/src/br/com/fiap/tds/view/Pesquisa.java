package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Pesquisa {

	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um Sistemao
		SistemaDao sistemaDao = new SistemaDaoImpl(em);
		
		try {
			//Pesquisar um sistema pelo código
			Sistema sistema = sistemaDao.findById(1);
			
			//Exibir o nome do sistema
			System.out.println(sistema.getNome());
	
			for (CasoTeste caso : sistema.getCasosTeste()) {
				//Exibir o nome e a descrição dos casos de teste
				System.out.println("\nCaso de Teste: " + caso.getNome() + " - " + caso.getDescricao());
				
				for (ItemTeste item : caso.getItensTeste()) {
					//Exibir a descrição dos itens de teste dos casos de teste
					System.out.println("\nItem de Teste: " + item.getDescricao());
					
					//Exibir os usuários relacionados aos itens de teste
					System.out.println("\nUsuários:");
					for (Usuario usuario: item.getUsuarios()) {
						System.out.println(usuario.getNome());
					}
				}
			}
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
}//classe