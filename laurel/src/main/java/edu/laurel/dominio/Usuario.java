package edu.laurel.dominio;

import edu.laurel.constantes.Equipo;

public class Usuario extends Base {
    private final String nombre;
    private final java.util.Set<Equipo> equipos;

    public Usuario(final String nombre) {
	super();
	this.nombre = nombre;
	equipos = new java.util.HashSet<Equipo>(5);
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