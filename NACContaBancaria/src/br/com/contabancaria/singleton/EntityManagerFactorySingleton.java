package br.com.contabancaria.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
	
	private static EntityManagerFactory fabrica;
	
	private EntityManagerFactorySingleton() {};
	
	private static EntityManagerFactory getInstance() {
		if(fabrica==null) {
			fabrica = Persistence.createEntityManagerFactory("teste");
		}
		return fabrica;
	}
}