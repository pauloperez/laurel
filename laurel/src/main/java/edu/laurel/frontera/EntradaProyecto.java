package edu.laurel.frontera;

import java.io.Serializable;
import java.util.Collection;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import edu.laurel.dominio.Laurel;
import edu.laurel.dominio.Proyecto;
import edu.laurel.dominio.Usuario;
import edu.laurel.dominio.error.NombreProyectoExistente;
import edu.laurel.repositorios.Raiz;

@Transactional
public class EntradaProyecto implements Serializable {

    private static final long serialVersionUID = 5735209983740584036L;

    @Inject
    @Raiz
    private Laurel laurel;


    public void registrar(final Proyecto proyecto) throws NombreProyectoExistente {
	laurel.registrar(proyecto);
    }

    public void borrar(final Proyecto proyecto) {
	laurel.borrar(proyecto);
    }

    public boolean estaRegistrado(final String nombreProyecto) {
	return laurel.estaRegistrado(nombreProyecto);
    }

    public Collection<Usuario> listaUsuarios() {
	return laurel.listaUsuarios();
    }
}
