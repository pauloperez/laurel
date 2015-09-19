package edu.laurel.dominio;

import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class TipoItem {
    private String nombre;
    private final java.util.Set<SecuenciaEstado> cicloDeVida;

    public TipoItem(final String nombre) {
	this.nombre = nombre;
	cicloDeVida = new java.util.HashSet<SecuenciaEstado>();
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public void agregarSecuencia(final EstadoItem inicio, final EstadoItem fin) {
	if (cicloDeVida.isEmpty())
	    cicloDeVida.add(new SecuenciaEstado(null, inicio));
	cicloDeVida.add(new SecuenciaEstado(inicio, fin));
    }

    public boolean tieneConfigurado(final EstadoItem estado) {
	for (final SecuenciaEstado secuenciaEstado : cicloDeVida)
	    if (secuenciaEstado.getFin().equals(estado))
		return true;
	return false;
    }

    public boolean puedeRealizarSecuencia(final EstadoItem actual, final EstadoItem siguiente) {
	return cicloDeVida.contains(new SecuenciaEstado(actual, siguiente));
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(3, 7). // two randomly chosen prime numbers
	// if deriving: appendSuper(super.hashCode()).
	append(nombre).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof TipoItem))
	    return false;

	final TipoItem rhs = (TipoItem) obj;
	return new EqualsBuilder().
	        // if deriving: appendSuper(super.equals(obj)).
	        append(nombre, rhs.nombre).isEquals();
    }

    @Override
    public String toString() {
	final int maxLen = 5;
	return "TipoItem [nombre=" + nombre + ", cicloDeVida="
	        + (cicloDeVida != null ? toString(cicloDeVida, maxLen) : null) + "]";
    }

    private String toString(final Collection<?> collection, final int maxLen) {
	final StringBuilder builder = new StringBuilder();
	builder.append("[");
	int i = 0;
	for (final Iterator<?> iterator = collection.iterator(); iterator.hasNext() && i < maxLen; i++) {
	    if (i > 0)
		builder.append(", ");
	    builder.append(iterator.next());
	}
	builder.append("]");
	return builder.toString();
    }

}
