package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

//CTRL + 1
public class ContaCorrente extends Conta {

	private TipoConta tipo;
	
//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		//validar se a conta é comum e o saldo fica negativo depois do saque
		if ( tipo == TipoConta.COMUM &&  valor > saldo) {
			throw new SaldoInsuficienteException(saldo);
		} 
		saldo -= valor;
	}
	
	//CRTL + 3 -> gcuf
	public ContaCorrente() {}
	
	public ContaCorrente(int agencia, int numero, Calendar dataAbertura, double saldo, 
																			TipoConta tipo) {
		super(agencia, numero, dataAbertura, saldo);
		this.tipo = tipo;
	}

	public TipoConta getTipo() {
		return tipo;
	}

	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}

}
