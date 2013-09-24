package edu.laurel.repositorios;

import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;

import edu.laurel.repositorios.estrategias.EstrategaRepositorio;

public class Repositorio<T> {

	@Inject
	EstrategaRepositorio estrategaRepositorio;

	public boolean existe(final Collection<T> coleccion,
			final Map<String, ?> parametros) {
		return estrategaRepositorio.existe(coleccion, parametros);
	}
}
