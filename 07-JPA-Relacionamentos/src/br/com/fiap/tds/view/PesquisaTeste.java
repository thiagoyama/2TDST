package br.com.fiap.tds.view;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.PadariaDao;
import br.com.fiap.tds.dao.impl.PadariaDaoImpl;
import br.com.fiap.tds.entity.Fornecedor;
import br.com.fiap.tds.entity.Padaria;
import br.com.fiap.tds.entity.Produto;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class PesquisaTeste {
	
	public static void main(String[] args) {
		//Obter um Entity Manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Obter uma PadariaDao
		PadariaDao dao = new PadariaDaoImpl(em);
		
		try {
			//Pesquisar uma padoca por código
			Padaria padoca = dao.findById(22);
		
			//Exibir o nome da padaria
			System.out.println(padoca.getNome());
		
			//Exibir o bairro da padaria
			System.out.println(padoca.getEndereco().getBairro());
			
			//Exibir o nome dos produtos da padaria
			List<Produto> produtos = padoca.getProdutos();
			System.out.println("Produtos:");
			for (Produto produto : produtos) {
				System.out.println(produto.getNome());
			}
			
			//Exibir os fornecedores da padaria
			System.out.println("Fornecedores");
			for (Fornecedor fornecedor : padoca.getFornecedores()) {
				System.out.println(fornecedor.getNome());
			}
		
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}

}
