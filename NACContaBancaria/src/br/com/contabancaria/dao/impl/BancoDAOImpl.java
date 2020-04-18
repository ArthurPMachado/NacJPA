package br.com.contabancaria.dao.impl;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.BancoDAO;
import br.com.contabancaria.entity.Banco;

public class BancoDAOImpl extends GenericDAOImpl<Banco, Integer> implements BancoDAO{
	
	public BancoDAOImpl(EntityManager manager) {
		super(manager);
	}
}
