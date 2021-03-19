package br.com.fiap.main;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.fiap.bean.ContaCorrente;
import br.com.fiap.bean.ContaPoupanca;
import br.com.fiap.bean.TipoConta;
import br.com.fiap.exception.SaldoInsuficienteException;

public class Exercicio06 {

	@SuppressWarnings("all")
	public static void main(String[] args) {
		//Instanciar uma conta corrente
		ContaCorrente cc = new ContaCorrente(
				1, 12343, Calendar.getInstance(), 100, TipoConta.COMUM);
		
		//Instanciar uma conta poupança
		ContaPoupanca cp = new ContaPoupanca(
				1, 3435, new GregorianCalendar(2020, Calendar.AUGUST, 9), 800, 1);
		
		//Realizar uma retirada
		try {
			cc.retirar(1000);
			System.out.println("Retirada efetuada!");
		} catch(SaldoInsuficienteException e) {
			System.out.println(e.getMessage());
		}
		
	}//main
	
}//classe
