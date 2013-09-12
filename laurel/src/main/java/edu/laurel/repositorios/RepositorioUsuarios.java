package edu.laurel.repositorios;

import java.util.HashMap;
import java.util.Map;

import edu.laurel.Usuario;

public class RepositorioUsuarios extends Repositorio<Usuario> {

	public boolean existeConNombre(final String nombreUsuario) {
		Map<String, String> parametros = new HashMap<String, String>();
		parametros.put("nombre", nombreUsuario);
		return super.existe(parametros);
	}

}
