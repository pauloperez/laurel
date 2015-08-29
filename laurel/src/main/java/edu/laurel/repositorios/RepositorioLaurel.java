package edu.laurel.repositorios;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import edu.laurel.dominio.Laurel;

@ApplicationScoped
public class RepositorioLaurel extends Repositorio<Laurel> {

	private static final long serialVersionUID = -7489574749156134567L;

	@Inject
	private RepositorioUsuarios repositorioUsuarios;

	@Raiz
	@Produces
	public Laurel obtenerLaurel() {
		Laurel laurel = encontrar(Laurel.class, 1);
		if (laurel == null)
			laurel = estrategaRepositorio.crearRaiz();
		laurel.setRepositorioUsuarios(repositorioUsuarios);
		return laurel;
	}
}
