package edu.laurel.dominio;

import edu.laurel.repositorios.RepositorioUsuarios;

public class Laurel extends Base {
	private static final long serialVersionUID = 6583391032605422260L;

	private java.util.Collection<Usuario> usuarios;
	private java.util.Collection<Proyecto> proyectos;

	//@Inject, no funciona con entities
	RepositorioUsuarios repositorioUsuarios;

	//Necesario para inyectar el repositorio desde un servicio
	public void setRepositorioUsuarios(final RepositorioUsuarios repositorioUsuarios) {
		this.repositorioUsuarios = repositorioUsuarios;
	}

	public Laurel() {
		super();
		setOid(1);
		usuarios = new java.util.HashSet<Usuario>();
		proyectos = new java.util.ArrayList<Proyecto>(5);
	}

	public java.util.Collection<Proyecto> getProyectos() {
		return proyectos;
	}

	public boolean estaRegistrado(final Proyecto proyecto) {
		return proyectos.contains(proyecto);
	}

	public void registrar(final Proyecto proyecto) {
		proyectos.add(proyecto);
	}

	public void borrar(final Proyecto proyecto) {
		proyectos.remove(proyecto);
	}

	public java.util.Collection<Usuario> getUsuarios() {
		return usuarios;
	}

	public boolean estaInscripto(final String nombreUsuario) {
		return repositorioUsuarios.existeConNombre(usuarios, nombreUsuario);
	}

	public void darAlta(final Usuario usuario) throws NombreUsuarioExistenteExcepcion {
		if (estaInscripto(usuario.getNombre()))
			throw new NombreUsuarioExistenteExcepcion();
		else
			usuarios.add(usuario);
	}

	public void darBaja(final Usuario usuario) {
		usuarios.remove(usuario);
	}
}