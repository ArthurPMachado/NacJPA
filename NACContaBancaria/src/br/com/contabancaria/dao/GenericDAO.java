package br.com.contabancaria.dao;

import br.com.contabancaria.exception.ErroChavePrimariaException;
import br.com.contabancaria.exception.ErroCommitException;

public interface GenericDAO<T, K> {
	void create(T entidade);
	T read(K codigo) throws ErroChavePrimariaException;
	void update(T entidade); 
	void delete(K codigo) throws ErroChavePrimariaException;
	void commit() throws ErroCommitException;
}
