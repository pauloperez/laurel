package edu.laurel.aplicacion;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import edu.laurel.dominio.Laurel;
import edu.laurel.dominio.Usuario;
import edu.laurel.repositorios.Raiz;

public class ServiciosUsuario {

	@Inject
	@Raiz
	private Laurel laurel;

	@Transactional
	public void alta(final Usuario usuario) {
		laurel.darAlta(usuario);
	}
}
