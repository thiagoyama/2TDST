package br.com.fiap.tds.view;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.bean.Usuario;

public class Teste {

	public static void main(String[] args) {
		//Instanciar um usuário
		Usuario usuario = new Usuario();
		
		//API Reflection -> obtem a estrutura da classe
		//Obter o nome da classe
		String nome = usuario.getClass().getName(); //getSimpleName();
		System.out.println(nome);
		
		//Obter os métodos da classe
		System.out.println("Métodos:");
		Method[] metodos = usuario.getClass().getDeclaredMethods();
		//Exibir o nome dos métodos
		for (Method m : metodos) {
			System.out.println(m.getName());
		}
		
		//Obter os atributos da classe
		System.out.println("Atributos:");
		Field[] atributos = usuario.getClass().getDeclaredFields();
		//Exibir o nome dos atributos e seu tipo
		for (Field f : atributos) {
			System.out.println(f.getName() + " " + f.getType());
			//Recuperar a anotação @Coluna
			Coluna a = f.getAnnotation(Coluna.class);
			//Exibir os parâmetros da @Coluna
			System.out.println("Coluna: " + a.nome() + " Pk: " +
					a.pk() + " Tamanho: " + a.tamanho());
		}
		
	}//main
	
}//classe