package edu.laurel.dominio;

import edu.laurel.constantes.Equipo;

public class Usuario extends Base {
	private static final long serialVersionUID = 4787763353620883240L;

	private String nombre;
	private java.util.Set<Equipo> equipos;

	protected Usuario() {
		super();
		equipos = new java.util.HashSet<Equipo>(5);
	}

	public Usuario(final String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public boolean esMiembro(final Equipo equipo) {
		return equipos.contains(equipo);
	}

	public void asignar(final Equipo equipo) {
		equipos.add(equipo);
	}

	public void quitar(final Equipo equipo) {
		equipos.remove(equipo);
	}
}