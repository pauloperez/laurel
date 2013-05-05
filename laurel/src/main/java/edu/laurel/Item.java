package edu.laurel;

import java.util.Date;

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
		this.creacion = new Date();
		camino = new java.util.ArrayDeque<EstadoItem>();

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

}
