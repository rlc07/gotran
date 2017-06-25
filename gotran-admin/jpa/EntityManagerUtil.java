package jpa;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private static EntityManagerFactory factory;
	private static EntityManager em;
	
	public static EntityManager getEntityManager(){
		
		if(factory == null){
			factory = Persistence.createEntityManagerFactory("gotran");
		}if(em == null){
			em = factory.createEntityManager();
		}
		return em;
	}

}
