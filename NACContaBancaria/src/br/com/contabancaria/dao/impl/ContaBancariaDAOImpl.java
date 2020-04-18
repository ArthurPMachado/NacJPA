package br.com.contabancaria.dao.impl;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.ContaBancariaDAO;
import br.com.contabancaria.entity.ContaBancaria;

public class ContaBancariaDAOImpl extends GenericDAOImpl<ContaBancaria, Integer> implements ContaBancariaDAO{

	public ContaBancariaDAOImpl(EntityManager manager) {
		super(manager);
	}
}
