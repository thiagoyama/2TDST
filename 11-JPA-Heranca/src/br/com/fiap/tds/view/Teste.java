package br.com.fiap.tds.view;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.fiap.tds.dao.PessoaDao;
import br.com.fiap.tds.dao.impl.PessoaDaoImpl;
import br.com.fiap.tds.entity.Pessoa;
import br.com.fiap.tds.entity.PessoaFisica;
import br.com.fiap.tds.entity.PessoaJuridica;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.EntityNotFoundException;
import br.com.fiap.tds.singleton.EntityManagerFactorySingleton;

public class Teste {
	
	public static void main(String[] args) {
		//Cadastrar uma pessoa, pessoa fisica e pessoa juridica:
		
		//Instanciar as classes
		Pessoa pessoa = new Pessoa("Salvio", new GregorianCalendar(2000, Calendar.APRIL, 10));
		
		PessoaFisica pf = 
				new PessoaFisica("Menk", Calendar.getInstance(), "123.234.123-2", "12.323.23-2");
		
		PessoaJuridica pj = 
				new PessoaJuridica("FIAP", new GregorianCalendar(1999, Calendar.JANUARY,8),
						"123.242.232/0001-23", 199932.0);
		
		//Instanciar um Entity Manager e o Dao
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PessoaDao dao = new PessoaDaoImpl(em);
		
		//Cadastrar
		try {
			dao.create(pessoa);
			dao.create(pj);
			dao.create(pf);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		//Pesquisar uma pessoa pela PK
		try {
			Pessoa busca = dao.findById(3);
			System.out.println(busca.getNome());
		} catch (EntityNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		//Fechar
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}

}
