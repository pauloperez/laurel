package edu.laurel.dominio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;


public class SecuenciaEstado {
    private final EstadoItem inicio;
    private EstadoItem fin;

    public SecuenciaEstado(final EstadoItem inicio, final EstadoItem fin) {
	this.inicio = inicio;
	this.fin = fin;
    }

    public SecuenciaEstado(final EstadoItem actual) {
	this(actual, null);
    }

    public EstadoItem getInicio() {
	return inicio;
    }

    public void setFin(final EstadoItem fin) {
	this.fin = fin;
    }

    public EstadoItem getFin() {
	return fin;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(17, 31). // two randomly chosen prime numbers
		// if deriving: appendSuper(super.hashCode()).
		append(inicio).append(fin).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof SecuenciaEstado))
	    return false;

	final SecuenciaEstado rhs = (SecuenciaEstado) obj;
	return new EqualsBuilder().
	// if deriving: appendSuper(super.equals(obj)).
		append(inicio, rhs.inicio).append(fin, rhs.fin).isEquals();
    }
}
