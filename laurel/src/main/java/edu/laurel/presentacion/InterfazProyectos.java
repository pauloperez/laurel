package edu.laurel.presentacion;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.dominio.Proyecto;
import edu.laurel.dominio.Usuario;
import edu.laurel.dominio.error.NombreProyectoExistente;
import edu.laurel.frontera.EntradaProyecto;

@Named
@ViewScoped
public class InterfazProyectos implements Serializable {

    private static final long serialVersionUID = 5040808907010877213L;

    @Inject
    EntradaProyecto entradaProyecto;

    private String nombreProyecto;
    private Usuario lider;

    @PostConstruct
    public void inicio() {
    }

    public void registrar() {
	final Proyecto proyecto = new Proyecto(nombreProyecto, lider);
	try {
	    entradaProyecto.registrar(proyecto);
	    final FacesMessage facesMessage = new FacesMessage("Proyecto " + proyecto.getNombre() + " creado.");
	    FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	} catch (final NombreProyectoExistente e) {
	    final FacesMessage facesMessage = new FacesMessage("Nombre de proyecto ya existe!");
	    FacesContext.getCurrentInstance().addMessage("altaProyecto:proyecto", facesMessage);

	}
    }

    public String getNombreProyecto() {
	return nombreProyecto;
    }

    public void setNombreProyecto(final String nombreProyecto) {
	this.nombreProyecto = nombreProyecto;
    }

    public Usuario getLider() {
	return lider;
    }

    public void setLider(final Usuario lider) {
	this.lider = lider;
    }

}
