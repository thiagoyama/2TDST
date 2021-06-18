package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.FuncionarioDao;
import br.com.fiap.tds.dao.impl.FuncionarioDaoImpl;
import br.com.fiap.tds.entity.Funcionario;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {

	public static void main(String[] args) {
		
		//Cadastrar um funcionario:
		
		//Instanciar um funcionario
		Funcionario func = new Funcionario("Allen", 
				new GregorianCalendar(2010, Calendar.JANUARY, 1), 20000.0, 1231, 53);
		
		//Obter um entity manager
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		//Instanciar um FuncionarioDao
		FuncionarioDao dao = new FuncionarioDaoImpl(em);
		
		//Cadastrar o funcionario
		try {
			dao.create(func);
			dao.commit();
			System.out.println("Funcionario registrado!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			//Pesquisar um funcionario pela PK:
			Funcionario busca = dao.findById(1);
			//Exibir o nome e salário 
			System.out.println(busca.getNome() + " " + busca.getSalario());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
		
	}//main
	
}//classe
