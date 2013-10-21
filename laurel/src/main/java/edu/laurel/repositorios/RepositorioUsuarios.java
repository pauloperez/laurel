package edu.laurel.repositorios;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import edu.laurel.dominio.Usuario;

public class RepositorioUsuarios extends Repositorio<Usuario> {

	public boolean existeConNombre(final Collection<Usuario> usuarios,
			final String nombreUsuario) {
		final Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("nombre", nombreUsuario);
		return super.existe(usuarios, parametros);
	}

}
