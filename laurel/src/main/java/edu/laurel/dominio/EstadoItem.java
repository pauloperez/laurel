package edu.laurel.dominio;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class EstadoItem {
    private String nombre;

    public EstadoItem(final String nombre) {
	this.nombre = nombre;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(37, 11). // two randomly chosen prime numbers
		// if deriving: appendSuper(super.hashCode()).
		append(nombre).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof EstadoItem))
	    return false;

	final EstadoItem rhs = (EstadoItem) obj;
	return new EqualsBuilder().
	// if deriving: appendSuper(super.equals(obj)).
		append(nombre, rhs.nombre).isEquals();
    }

    @Override
    public String toString() {
	return "EstadoItem [nombre=" + nombre + "]";
    }
}
