package edu.laurel.repositorios.estrategias;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import edu.laurel.dominio.Laurel;

public abstract class EstrategaRepositorio<T> implements Serializable {

    private static final long serialVersionUID = 3147303138209586719L;

    public abstract T encontrar(final Class<T> clase, final int oid);

    public abstract List<T> buscar(Class<T> clase, Map<String, ?> parametros);

    public abstract boolean existe(final Collection<T> coleccion, final Class<T> clase, final Map<String, ?> parametros);

    public Laurel crearRaiz() {
	return new Laurel();
    }

}
