package edu.laurel.dominio;

import java.util.Date;

import edu.laurel.constantes.Equipo;

public class Usuario extends Base {
	private static final long serialVersionUID = 4787763353620883240L;

	private String nombre;
	private String password;
	private Date registro;
	private Boolean activo;
	private java.util.Set<Equipo> equipos;

	protected Usuario() {
		super();
		registro = new Date();
		activo = true;
		equipos = new java.util.HashSet<Equipo>(5);
	}

	public Usuario(final String nombre, final String password) {
		this();
		this.nombre = nombre;
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPassword() {
		return password;
	}

	public Date getRegistro() {
		return registro;
	}

	public Boolean estaActivo() {
		return activo;
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