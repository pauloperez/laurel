package edu.laurel.dominio;

import javax.inject.Inject;

import edu.laurel.repositorios.RepositorioUsuarios;

public class Laurel {
    private int oid;
    private java.util.Collection<Usuario> usuarios;
    private java.util.Collection<Proyecto> proyectos;

    @Inject
    RepositorioUsuarios repositorioUsuarios;

    public Laurel() {
	usuarios = new java.util.HashSet<Usuario>();
	proyectos = new java.util.ArrayList<Proyecto>(5);
    }

    public int getOid() {
	return oid;
    }

    public void setOid(int oid) {
	this.oid = oid;
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

    public void darAlta(final Usuario usuario) {
	usuarios.add(usuario);
    }

    public void darBaja(final Usuario usuario) {
	usuarios.remove(usuario);
    }
}