package br.com.fiap.tds.dao;

import br.com.fiap.tds.entity.Filme;
import br.com.fiap.tds.exception.CommitException;
import br.com.fiap.tds.exception.FilmeNotFoundException;

// Interface -> diminuir o acoplamento (dependência) entre os objetos
// View - Controller (FilmeDao) - Dao - Banco

public interface FilmeDao {

	void create(Filme filme);
	
	Filme findById(int id) throws FilmeNotFoundException;
	
	void update(Filme filme);
	
	void remove(int id) throws FilmeNotFoundException ;
	
	void commit() throws CommitException;
	
}