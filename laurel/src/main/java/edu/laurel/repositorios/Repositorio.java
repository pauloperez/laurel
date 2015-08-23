package edu.laurel.repositorios;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

import javax.inject.Inject;

import edu.laurel.repositorios.estrategias.EstrategaRepositorio;

public abstract class Repositorio<T> implements Serializable {

	private static final long serialVersionUID = -5448041219980153305L;

	@Inject
	EstrategaRepositorio<T> estrategaRepositorio;

	public T encontrar(final Class<T> clase, final int oid) {
		return estrategaRepositorio.encontrar(clase, oid);
	}

	public boolean existe(final Collection<T> coleccion, final Class<T> clase, final Map<String, ?> parametros) {
		return estrategaRepositorio.existe(coleccion, clase, parametros);
	}
}
