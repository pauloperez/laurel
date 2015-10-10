package edu.laurel.repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import edu.laurel.dominio.Proyecto;

@ApplicationScoped
public class RepositorioProyectos extends Repositorio<Proyecto> {

    private static final long serialVersionUID = -8743544318071803488L;

    public boolean existeConNombre(final Collection<Proyecto> proyectos, final String nombreProyecto) {
	final Map<String, String> parametros = new HashMap<String, String>();
	parametros.put("nombre", nombreProyecto);
	return super.existe(proyectos, Proyecto.class, parametros);
    }

}
