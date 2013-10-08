package edu.laurel.dominio;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import edu.laurel.constantes.Prioridad;

public class Item {
    private Prioridad prioridad;
    private TipoItem tipo;
    private final java.util.Deque<EstadoItem> camino;
    private Usuario responsable;
    private final Date creacion;
    private String descripcion;

    public Item(final TipoItem tipo, final Prioridad prioridad) {
	this.prioridad = prioridad;
	this.tipo = tipo;
	creacion = new Date();
	camino = new java.util.ArrayDeque<EstadoItem>();
    }

    /**
     * Construye el Item con el tipoItem parametrizado y con Prioridad Medio
     * 
     * @param tipoItem
     */
    public Item(final TipoItem tipoItem) {
	this(tipoItem, Prioridad.MEDIA);
    }

    public Prioridad getPrioridad() {
	return prioridad;
    }

    public void setPrioridad(final Prioridad prioridad) {
	this.prioridad = prioridad;
    }

    public TipoItem getTipo() {
	return tipo;
    }

    public void setTipo(final TipoItem tipo) {
	this.tipo = tipo;
    }

    public Usuario getResponsable() {
	return responsable;
    }

    public void setResponsable(final Usuario responsable) {
	this.responsable = responsable;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(final String descripcion) {
	this.descripcion = descripcion;
    }

    public java.util.Deque<EstadoItem> getCamino() {
	return camino;
    }

    public Date getCreacion() {
	return creacion;
    }

    public EstadoItem verEstadoActual() {
	return camino.peek();
    }

    public void pasarA(final EstadoItem estadoSiguiente) {
	if (tipo.puedeRealizarSecuencia(verEstadoActual(), estadoSiguiente))
	    camino.push(estadoSiguiente);
    }

    @Override
    public int hashCode() {
	return new HashCodeBuilder(17, 3). // two randomly chosen prime numbers
		// if deriving: appendSuper(super.hashCode()).
		append(creacion).append(prioridad).append(tipo).toHashCode();
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof Item))
	    return false;

	final Item rhs = (Item) obj;
	return new EqualsBuilder()
		.
		// if deriving: appendSuper(super.equals(obj)).
		append(creacion, rhs.creacion).append(prioridad, rhs.prioridad)
		.append(tipo, rhs.tipo).isEquals();
    }
}
