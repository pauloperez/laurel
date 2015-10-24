package edu.laurel.repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;

import edu.laurel.dominio.Usuario;

@ApplicationScoped
public class RepositorioUsuarios extends Repositorio<Usuario> {

    private static final long serialVersionUID = -8743544318071803488L;

    public boolean existeConNombre(final Collection<Usuario> usuarios, final String nombreUsuario) {
	final Map<String, String> parametros = new HashMap<String, String>();
	parametros.put("nombre", nombreUsuario);
	return super.existe(usuarios, Usuario.class, parametros);
    }

    public List<Usuario> listar() {
	final Map<String, Object> parametros = new HashMap<String, Object>();
	parametros.put("activo", Boolean.TRUE);
	return super.buscar(Usuario.class, parametros);
    }

}
