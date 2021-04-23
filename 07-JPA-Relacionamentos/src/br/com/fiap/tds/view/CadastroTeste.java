package br.com.fiap.tds.view;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.EnderecoDao;
import br.com.fiap.tds.dao.PadariaDao;
import br.com.fiap.tds.dao.impl.EnderecoDaoImpl;
import br.com.fiap.tds.dao.impl.PadariaDaoImpl;
import br.com.fiap.tds.entity.Endereco;
import br.com.fiap.tds.entity.Fornecedor;
import br.com.fiap.tds.entity.Padaria;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class CadastroTeste {

	//Cadastrar um endereço e uma padaria relacionados
	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter o EnderecoDao e PadariaDao
		PadariaDao padocaDao = new PadariaDaoImpl(em);
		EnderecoDao enderecoDao = new EnderecoDaoImpl(em);
		
		//Instanciar um endereco
		Endereco endereco = new Endereco("Av lins de vasconcelos", "1222", "Aclimação");
		
		//Instanciar um padaria com o endereco
		Padaria padoca = new Padaria("Bispo", 10000.0, "Seg. a Sex. 6h - 22h", endereco);
		
		//Cadastrar um endereco 
		//enderecoDao.create(endereco);
		
		//Instanciar 3 produtos 
		Produto produto1 = new Produto("Pão", "Pão francês", 12.0);
		Produto produto2 = new Produto("Bolo", "Bolo de laranja", 20.0);
		Produto produto3 = new Produto("Café", "Media", 4.0);
		
		//Adicionar os produtos na padaria
		padoca.addProduto(produto1);
		padoca.addProduto(produto2);
		padoca.addProduto(produto3);
		
		//Instanciar 2 fornecedores 
		Fornecedor fornecedor1 = new Fornecedor("Bebidas S/A", "(11) 927829323", "contato@bebidas.com");
		Fornecedor fornecedor2 = new Fornecedor("Alimentos Ltda", "(41) 98892323", "alimentos@gmail.com");
		
		//Criar uma lista de fornecedores e adiciona-los na lista
		List<Fornecedor> lista = new ArrayList<>();
		lista.add(fornecedor1);
		lista.add(fornecedor2);
		
		//Adicionar a lista na padaria
		padoca.setFornecedores(lista);
		
		//Cadastrar uma padaria
		padocaDao.create(padoca);
		
		//Commit
		try {
			padocaDao.commit();
			System.out.println("Padaria e endereço cadastrados!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
	
}
