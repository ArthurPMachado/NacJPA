package br.com.contabancaria.dao.impl;

import javax.persistence.EntityManager;

import br.com.contabancaria.dao.ClienteDAO;
import br.com.contabancaria.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente, Integer> implements ClienteDAO{

	public ClienteDAOImpl(EntityManager manager) {
		super(manager);
	}

}
