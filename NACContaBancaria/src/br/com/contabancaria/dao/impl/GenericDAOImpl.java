package br.com.contabancaria.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.GenericDAO;
import br.com.contabancaria.exception.ErroChavePrimariaException;
import br.com.contabancaria.exception.ErroCommitException;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K>{
	private EntityManager manager;
	private Class<T> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager manager) {
		this.manager = manager;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	@Override
	public void create(T entidade) {
		manager.persist(entidade);
	}

	@Override
	public T read(K codigo) throws ErroChavePrimariaException {
		T entidade = manager.find(clazz, codigo);
		if(entidade==null) {
			throw new ErroChavePrimariaException();
		}
		return entidade;
	}

	@Override
	public void update(T entidade) {
		manager.merge(entidade);
	}

	@Override
	public void delete(K codigo) throws ErroChavePrimariaException {
		T entidade = read(codigo);
		manager.remove(entidade);
	}

	@Override
	public void commit() throws ErroCommitException {
		try {
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		} catch (Exception exception) {
			exception.printStackTrace();
			manager.getTransaction().rollback();
			throw new ErroCommitException();
		}
	}

}
