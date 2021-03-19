package br.com.fiap.tds.bean;

import br.com.fiap.tds.annotation.Coluna;
import br.com.fiap.tds.annotation.Tabela;

@Tabela(nome= "TB_USUARIO")
public class Usuario {

	@Coluna(nome="cd_usuario", pk=true)
	private int codigo;
	
	@Coluna(nome="nm_usuario", tamanho = 100)
	private String nome;
	
	@Coluna(nome="ds_email", tamanho = 100)
	private String email;
	
	//CTRL + 3 -> ggas

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}