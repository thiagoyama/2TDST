package br.com.fiap.bean;

import java.util.Calendar;

import br.com.fiap.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta implements ContaInvestimento {

	private float taxa;
	
	//final:
	// atributo -> não permite alterar o valor
	// método -> não permite a sobrescrita
	// classe -> não permite herança
	//static: define que o método/atributo é de classe e não de objeto
	public static final float RENDIMENTO = 0.04f;
	
	@Override
	public double calculaRetornoInvestimento() {
		return saldo * RENDIMENTO;
	}

//	@Override
//	public void depositar(double valor) {
//		saldo += valor;
//	}

	@Override
	public void retirar(double valor) throws SaldoInsuficienteException {
		if (taxa + valor > saldo) {
			throw new SaldoInsuficienteException(saldo - taxa);
		}
		saldo -= valor + taxa;
	}
	
	//CTRL + 3 -> gcuf (construtores)
	public ContaPoupanca() {}

	public ContaPoupanca(int agencia, int numero, Calendar dataAbertura, 
														double saldo, float taxa) {
		super(agencia, numero, dataAbertura, saldo);
		this.taxa = taxa;
	}
	
	public float getTaxa() {
		return taxa;
	}

	public void setTaxa(float taxa) {
		this.taxa = taxa;
	}

}
