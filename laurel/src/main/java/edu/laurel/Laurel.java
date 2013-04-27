package edu.laurel;


public class Laurel {
	private final java.util.Set<Usuario> usuarios;
	private final java.util.Collection<Proyecto> proyectos;

	public Laurel() {
		usuarios = new java.util.HashSet<Usuario>();
		proyectos = new java.util.ArrayList<Proyecto>(5);
	}

	public java.util.Collection<Proyecto> getProyectos() {
		return proyectos;
	}

	public boolean estaRegistrado(final Proyecto proyecto) {
		return proyectos.contains(proyecto);
	}

	public void registrar(final Proyecto proyecto){
		proyectos.add(proyecto);
	}

	public void borrar(final Proyecto proyecto) {
		proyectos.remove(proyecto);
	}

	public java.util.Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public boolean estaInscripto(final Usuario usuario) {
		return usuarios.contains(usuario);
	}

	public void darAlta(final Usuario  usuario) {
		usuarios.add(usuario);
	}

	public void darBaja(final Usuario usuario) {
		usuarios.remove(usuario);
	}
}