package br.com.fiap.tds.main;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.ItemPedidoDao;
import br.com.fiap.tds.dao.impl.ItemPedidoDaoImpl;
import br.com.fiap.tds.entity.ItemPedido;
import br.com.fiap.tds.entity.ItemPedidoPK;
import br.com.fiap.tds.entity.Pedido;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Cadastrar todas as entidades
		//Instanciar um produto
		Produto produto = new Produto("Fone");
		
		//Instanciar um pedido
		Pedido pedido = new Pedido("Online", Calendar.getInstance());
		
		//Instanciar um item pedido com o produto e pedido
		ItemPedido item = new ItemPedido(pedido, produto, 150.0, 10);
		
		//Obter item pedido dao
		ItemPedidoDao dao = new ItemPedidoDaoImpl(em);
		
		//Cadastrar o item pedido
		try {
			dao.create(item);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar um item pedido pela PK
		try {
			ItemPedidoPK pk = new ItemPedidoPK(1, 1, 1);
			ItemPedido busca = dao.findById(pk);
			System.out.println(busca.getProduto().getNome() + " " + busca.getValor());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe