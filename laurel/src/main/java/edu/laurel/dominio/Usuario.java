package edu.laurel.dominio;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;

import edu.laurel.constantes.Equipo;

public class Usuario extends Base {
    private static final long serialVersionUID = 4787763353620883240L;

    private String nombre;
    private String usuario;
    private String password;
    private Date registro;
    private Boolean activo;
    private java.util.Set<Equipo> equipos;

    public Usuario() {
	super();
	registro = new Date();
	activo = true;
	equipos = new java.util.HashSet<Equipo>(5);
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(final String nombre) {
	this.nombre = nombre;
    }

    public String getUsuario() {
	return usuario;
    }

    public void setUsuario(final String usuario) {
	this.usuario = usuario;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(final String password) {
	this.password = password;
    }

    public Date getRegistro() {
	return registro;
    }

    protected void setRegistro(final Date registro) {
	this.registro = registro;
    }

    public Boolean estaActivo() {
	return activo;
    }

    public void setActivo(final Boolean activo) {
	this.activo = activo;
    }

    public boolean esMiembro(final Equipo equipo) {
	return equipos.contains(equipo);
    }

    public java.util.Set<Equipo> getEquipos() {
	return equipos;
    }

    public void setEquipos(final java.util.Set<Equipo> equipos) {
	this.equipos = equipos;
    }

    @Override
    public boolean equals(final Object obj) {
	if (obj == null)
	    return false;
	if (obj == this)
	    return true;
	if (!(obj instanceof Usuario))
	    return false;

	final Usuario rhs = (Usuario) obj;
	return new EqualsBuilder().
	        // if deriving: appendSuper(super.equals(obj)).
	        append(nombre, rhs.nombre).isEquals();
    }

    @Override
    public String toString() {
	return String.format("Usuario [nombre=%s, usuario=%s, password=%s, registro=%s, activo=%s, equipos=%s]", nombre,
	        usuario, password, registro, activo, equipos);
    }

}