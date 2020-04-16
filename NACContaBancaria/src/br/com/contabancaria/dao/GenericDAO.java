package br.com.contabancaria.dao;

public interface GenericDAO<T, K> {
	void create(T entidade);
	T read(K codigo);
	void update(T entidade); 
	void delete(K codigo);
	void commit();
}
