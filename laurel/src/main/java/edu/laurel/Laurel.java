package edu.laurel;

import java.util.HashSet;

public class Laurel {
	private java.util.Set<Usuario> usuarios;
	private java.util.Collection<Proyecto> proyectos;
	private java.util.Collection<Equipo> equipos;
	
	public java.util.Set<Usuario> getUsuarios() {
		if(usuarios==null)
			usuarios = new HashSet<Usuario>();
		return usuarios;
	}
	
	public boolean exist(Usuario usuario) {
		return getUsuarios().contains(usuario);
	}

	public void addUsuario(Usuario  usuario) {
		getUsuarios().add(usuario);
	}

	public void removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
	}
}