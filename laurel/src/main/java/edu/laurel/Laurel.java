package edu.laurel;


public class Laurel {
	private java.util.Set<Usuario> usuarios;
	private java.util.Collection<Proyecto> proyectos;
	
	public Laurel() {
		usuarios = new java.util.HashSet<Usuario>();
		proyectos = new java.util.ArrayList<Proyecto>(5);
	}
	
	public void registrar(Proyecto proyecto){
		proyectos.add(proyecto);
	}
	
	public java.util.Set<Usuario> lista() {
		return usuarios;
	}
	
	public boolean estaRegistrado(Usuario usuario) {
		return usuarios.contains(usuario);
	}

	public void darAlta(Usuario  usuario) {
		usuarios.add(usuario);
	}

	public void darBaja(Usuario usuario) {
		usuarios.remove(usuario);
	}
}