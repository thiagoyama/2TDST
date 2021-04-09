package br.com.fiap.tds.exception;

public class FilmeNotFoundException extends Exception {

	public FilmeNotFoundException() {
		super("Filme não encontrado");
	}
	
	public FilmeNotFoundException(String msg) {
		super(msg);
	}
	
}
