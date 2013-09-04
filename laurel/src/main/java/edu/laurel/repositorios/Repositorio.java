package edu.laurel.repositorios;

import javax.inject.Inject;

public class Repositorio<T> {

	@Inject
	EstrategiaRepositorio estrategiaRepositorio;

	public boolean existe(final T t, final java.util.Map<String, ?> parametros) {
		return estrategiaRepositorio.existe(t, parametros);
	}
}
