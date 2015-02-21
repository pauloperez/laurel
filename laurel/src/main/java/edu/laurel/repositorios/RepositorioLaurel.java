package edu.laurel.repositorios;

import javax.enterprise.inject.Produces;

import edu.laurel.dominio.Laurel;

public class RepositorioLaurel extends Repositorio<Laurel> {

	@Raiz
	@Produces
	public Laurel obtenerLaurel() {
		Laurel laurel = encontrar(Laurel.class, 1);
		if (laurel == null)
			laurel = estrategaRepositorio.crearRaiz();
		return laurel;
	}
}
