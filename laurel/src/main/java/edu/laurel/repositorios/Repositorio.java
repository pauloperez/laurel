package edu.laurel.repositorios;

import java.util.Map;

import javax.inject.Inject;

public class Repositorio<T> {

	@Inject
	EstrategiaRepositorio estrategiaRepositorio;

	public boolean existe(final Map<String, ?> parametros) {
		return estrategiaRepositorio.existe(parametros);
	}
}
