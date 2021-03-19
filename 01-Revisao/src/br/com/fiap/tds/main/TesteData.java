 package br.com.fiap.tds.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TesteData {

	public static void main(String[] args) {
		//Instanciar um objeto de data com a data atual
		Calendar hoje = Calendar.getInstance();
		
		//Recupera o dia do mês (YEAR, MONTH)
		int dia = hoje.get(Calendar.DAY_OF_MONTH);
		
		//Instanciar um objeto de data com a data de entrega da challenge
												// ano, mes, dia
		Calendar challenge = new GregorianCalendar(2021, Calendar.APRIL, 4);
		
		//Objeto que formata a data
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy hh:mm aaa");
		
		//Exibir a data
		System.out.println( formatador.format(hoje.getTime()) );
		
		//Exibir a data de entrega da challenge
		System.out.println( formatador.format(challenge.getTime()) );
		
	}//main
	
}//classe
