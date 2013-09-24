package edu.laurel.repositorios.estrategias;

import java.util.Collection;
import java.util.Map;

public abstract class EstrategaRepositorio {

	public abstract <T> boolean existe(final Collection<T> coleccion,
			final Map<String, ?> parametros);
}
