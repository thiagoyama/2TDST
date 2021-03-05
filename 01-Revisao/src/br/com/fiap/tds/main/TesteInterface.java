package br.com.fiap.tds.main;

import br.com.fiap.tds.bean.Carro;
import br.com.fiap.tds.dao.CarroDao;
import br.com.fiap.tds.dao.CarroMySqlDao;

//View (JSP) <-> Controller (Servlet) CarroDao <-> DAO <-> Banco de Dados

public class TesteInterface {

	public static void main(String[] args) {
		
		//Instanciar um objeto do tipo CarroDao
		CarroDao dao = new CarroMySqlDao();
		
		//Chamar o método de cadastro
		dao.cadastrar(new Carro(1999, "Uno mille"));
		
	}
	
}