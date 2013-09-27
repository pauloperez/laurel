package edu.laurel.repositorios.estrategias;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.enterprise.inject.Alternative;

@Alternative
public class EstrategaMockRepositorio extends EstrategaRepositorio {

	@Override
	public <T> boolean existe(final Collection<T> coleccion, final Map<String, ?> parametros) {
		boolean existe = false;
		final Iterator<T> iterador = coleccion.iterator();
		while (iterador.hasNext()) {
			final T t = iterador.next();
			for (final String nombreParametro : parametros.keySet())
				try {
					final Field campo = t.getClass().getField(nombreParametro);
					if(parametros.get(nombreParametro).equals(campo.get(t)))
						existe = true;
				} catch (final NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (final SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}  catch (final IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (final IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return existe;
	}
}