package edu.laurel.presentacion;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.dominio.NombreUsuarioExistenteExcepcion;
import edu.laurel.dominio.Proyecto;
import edu.laurel.dominio.Usuario;

@Named
@ViewScoped
public class InterfazProyectos implements Serializable {

    private static final long serialVersionUID = 5040808907010877213L;

    @Inject
    EntradaProyecto entradaProyecto;

    private Proyecto proyecto;


    public Usuario getUsuario() {
	return usuario;
    }

    @PostConstruct
    public void inicio() {

	proyecto = new Proyecto();

    }

    public void alta() {
	try {
	    entradaUsuario.alta(usuario);
	    final FacesMessage facesMessage = new FacesMessage("Usuario " + usuario.getUsuario() + " creado.");
	    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	    inicio();
	} catch (final NombreUsuarioExistenteExcepcion e) {
	    final FacesMessage facesMessage = new FacesMessage("Nombre de usuario ya existe!");
	    FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);

	}
    }

    public void validarNombreUsuario() {
	if (entradaUsuario.estaInscripto(usuario.getUsuario())) {
	    final FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
		    "Nombre de usuario ya existe!", "");
	    FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);
	}
    }
}
