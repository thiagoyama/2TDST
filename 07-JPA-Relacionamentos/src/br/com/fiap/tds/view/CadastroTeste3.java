package br.com.fiap.tds.view;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.GenericDao;
import br.com.fiap.tds.dao.PadariaDao;
import br.com.fiap.tds.dao.impl.GenericDaoImpl;
import br.com.fiap.tds.dao.impl.PadariaDaoImpl;
import br.com.fiap.tds.entity.Fornecedor;
import br.com.fiap.tds.entity.Padaria;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste3 {
	
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar uma PadariaDao e ProdutoDao
		PadariaDao padariaDao = new PadariaDaoImpl(em);
		GenericDao<Produto,Integer> produtoDao = new GenericDaoImpl<Produto, Integer>(em) {};
		
		//1 - Cadastrar um produto associado a uma padaria que existe no banco:
		try {
			//Pesquisar uma padaria
			Padaria padaria = padariaDao.findById(1);
			
			//Instanciar uma produto com a padaria
			Produto produto = new Produto("Pizza", "Pizza tradicional", 40.0);
			produto.setPadaria(padaria);
			
			//Cadastrar o produto
			produtoDao.create(produto);
			produtoDao.commit();
			System.out.println("Produto registrado!");
			
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//2 - Associar uma padaria a um fornecedor que já existem no banco
		//Instanciar um FornecedorDao
		GenericDao<Fornecedor,Integer> fornecedorDao = new GenericDaoImpl<Fornecedor,Integer>(em){};
		
		try {
			//Pesquisar uma padaria
			Padaria padaria = padariaDao.findById(1);
			
			//Pesquisar um fornecedor
			Fornecedor fornecedor = fornecedorDao.findById(3);
			
			//Adicionar o fornecedor na lista de fornecedores da padaria
			padaria.getFornecedores().add(fornecedor);
			
			//Atualizar a padaria
			padariaDao.update(padaria);
			padariaDao.commit();
			System.out.println("Padaria e fornecedores associados!");
		
		} catch (EntityNotFoundException | CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main

}//classe
