package edu.laurel.dominio;

import java.util.List;

import edu.laurel.dominio.error.NombreProyectoExistente;
import edu.laurel.dominio.error.NombreUsuarioExistente;
import edu.laurel.repositorios.RepositorioProyectos;
import edu.laurel.repositorios.RepositorioUsuarios;

public class Laurel extends Base {
    private static final long serialVersionUID = 6583391032605422260L;

    private java.util.Collection<Usuario> usuarios;
    private java.util.Collection<Proyecto> proyectos;

    //@Inject, no funciona con entities
    RepositorioUsuarios repositorioUsuarios;
    RepositorioProyectos repositorioProyectos;

    //Necesario para inyectar el repositorio desde un servicio
    public void setRepositorioUsuarios(final RepositorioUsuarios repositorioUsuarios) {
	this.repositorioUsuarios = repositorioUsuarios;
    }

    public void setRepositorioProyectos(final RepositorioProyectos repositorioProyectos) {
	this.repositorioProyectos = repositorioProyectos;
    }

    public Laurel() {
	super();
	setOid(1);
	usuarios = new java.util.HashSet<Usuario>();
	proyectos = new java.util.HashSet<Proyecto>();
    }

    public java.util.Collection<Proyecto> getProyectos() {
	return proyectos;
    }

    public boolean estaRegistrado(final String nombreProyecto) {
	return repositorioProyectos.existeConNombre(proyectos, nombreProyecto);
    }

    public void registrar(final Proyecto proyecto) throws NombreProyectoExistente {
	if (estaRegistrado(proyecto.getNombre()))
	    throw new NombreProyectoExistente();
	else
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

    public void darAlta(final Usuario usuario) throws NombreUsuarioExistente {
	if (estaInscripto(usuario.getNombre()))
	    throw new NombreUsuarioExistente();
	else
	    usuarios.add(usuario);
    }

    public void darBaja(final Usuario usuario) {
	usuarios.remove(usuario);
    }

    public List<Usuario> listarUsuarios() {
	return repositorioUsuarios.listar();
    }

    public Usuario buscarUsuario(final int oid) {
	return repositorioUsuarios.buscar(Usuario.class, oid);
    }
}