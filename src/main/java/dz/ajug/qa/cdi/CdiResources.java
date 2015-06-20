package dz.ajug.qa.cdi;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

public class CdiResources {

	@PersistenceContext
	EntityManager em;

	@Produces
	public EntityManager createEm() {
		if (em == null) {
			synchronized (CdiResources.class) {
				EntityManagerFactory emf = Persistence
						.createEntityManagerFactory("AjugQAPU");
				em = emf.createEntityManager();
			}
		}
		return em;
	}

}
