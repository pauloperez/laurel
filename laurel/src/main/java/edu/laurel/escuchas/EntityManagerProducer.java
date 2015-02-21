package edu.laurel.escuchas;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;


@ApplicationScoped
public class EntityManagerProducer {
    @Inject
    @PersistenceUnitName("laurelPU")
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @Default
    @RequestScoped
    public EntityManager create() {
	return entityManagerFactory.createEntityManager();
    }

    public void dispose(@Disposes @Default final EntityManager entityManager) {
	if (entityManager.isOpen())
	    entityManager.close();
    }
}