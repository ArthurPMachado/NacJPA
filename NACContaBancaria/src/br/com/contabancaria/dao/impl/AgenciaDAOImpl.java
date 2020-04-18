package br.com.contabancaria.dao.impl;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.AgenciaDAO;
import br.com.contabancaria.entity.Agencia;

public class AgenciaDAOImpl extends GenericDAOImpl<Agencia, Integer> implements AgenciaDAO{
	
	public AgenciaDAOImpl(EntityManager manager) {
		super(manager);
	}
}
