package edu.laurel.aplicacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServiciosUsuario {

    @PersistenceContext(unitName = "laurel-pu")
    private EntityManager entityManager;

}
