package edu.laurel.repositorios.estrategias;

import java.util.Collection;
import java.util.Map;

import edu.laurel.dominio.Laurel;

public abstract class EstrategaRepositorio {

	public abstract <T> T encontrar(final Class<T> clase, final int oid);

	public abstract <T> boolean existe(final Collection<T> coleccion, final Map<String, ?> parametros);

	public Laurel crearRaiz() {
		return new Laurel();
	}
}
