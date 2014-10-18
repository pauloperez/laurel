package edu.laurel.aplicacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import edu.laurel.dominio.Usuario;

@Stateless
public class ServiciosUsuario {

    @PersistenceContext(unitName = "laurel-pu")
    private EntityManager entityManager;

    public void alta(final Usuario usuario) {
	// entityManager.persist(usuario);
    }

}
