package br.com.contabancaria.dao.impl;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.CeoDAO;
import br.com.contabancaria.entity.Ceo;

public class CeoDAOImpl extends GenericDAOImpl<Ceo, Integer> implements CeoDAO{

	public CeoDAOImpl(EntityManager manager) {
		super(manager);
	}
	
}
