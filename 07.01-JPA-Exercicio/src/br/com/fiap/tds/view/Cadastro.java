package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.SistemaDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.SistemaDaoImpl;
import br.com.fiap.tds.entity.CasoTeste;
import br.com.fiap.tds.entity.ItemTeste;
import br.com.fiap.tds.entity.Sistema;
import br.com.fiap.tds.entity.Usuario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Cadastro {

	//Cadastrar todas as entidades relacionadas
	public static void main(String[] args) {
		
		//Instanciar um sistema com o nome
		Sistema sistema = new Sistema("Portal Fiap");
		
		//Instanciar 2 casos de teste com o nome e descrição
		CasoTeste caso1 = new CasoTeste("Entrega Challenge", "Sistema de entrega dos trabalhos");
		CasoTeste caso2 = new CasoTeste("Boletim", "Sistema de notas");
		
		//Adicionar os casos de teste no sistema
		sistema.addCasoTeste(caso1);
		sistema.addCasoTeste(caso2);
		
		//Instanciar 3 itens de teste com a descrição
		ItemTeste item1 = new ItemTeste("Upload de arquivo de 100mb com sucesso");
		ItemTeste item2 = new ItemTeste("Não permitir a entrega de arquivo com 0kb");
		
		ItemTeste item3 = new ItemTeste("Publica notas após o lançamento e confirmação do token");
		
		//Adicionar 2 itens no primeiro caso e 1 item no segundo
		caso1.addItemTeste(item1);
		caso1.addItemTeste(item2);
		
		caso2.addItemTeste(item3);
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um SistemaDao
		SistemaDao sistemaDao = new SistemaDaoImpl(em);
		
		try {
			//Cadastrar o sistema
			sistemaDao.create(sistema);
			sistemaDao.commit();
			System.out.println("Sucesso!");
			
		} catch (CommitException e) {
			System.out.println("Deu ruim..");
		}
		
		//Criar uma lista de itens
		List<ItemTeste> lista = new ArrayList<>();
		lista.add(item1);
		lista.add(item3);
		
		//Instanciar o usuário com a lista de itens
		Usuario usuario1 = new Usuario("Gabriel", lista);
		Usuario usuario2 = new Usuario("Allan", lista);
		
		GenericDao<Usuario,Integer> usuarioDao = new GenericDaoImpl<Usuario,Integer>(em) {};
	
		try {
			//Cadastrar os usuários
			usuarioDao.create(usuario1);
			usuarioDao.create(usuario2);
			usuarioDao.commit();
			System.out.println("Usuários registrados!");
			
		} catch(CommitException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe
