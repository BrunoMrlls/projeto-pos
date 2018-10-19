package br.com.pos.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFabrica {
	
	private static EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFabrica() {}
	
	public static EntityManager getEntityManager() {
		if (entityManagerFactory == null) {
			entityManagerFactory = Persistence.createEntityManagerFactory("uPos");	
		}
		return entityManagerFactory.createEntityManager();
	}

}
