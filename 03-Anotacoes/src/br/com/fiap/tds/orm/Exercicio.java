package br.com.fiap.tds.orm;

import br.com.fiap.tds.bean.Aluno;
import br.com.fiap.tds.bean.Usuario;

public class Exercicio {

	public static void main(String[] args) {
		//Instanciar um Aluno e Usuario
		Aluno aluno = new Aluno();
		Usuario usuario = new Usuario();
		
		//Instanciar um Orm
		Orm orm = new Orm();
		
		//Chamar o método gerarPesquisa e exibir o resultado
		System.out.println(orm.gerarPesquisa(aluno));
		System.out.println(orm.gerarPesquisa(usuario));
	}
	
}
