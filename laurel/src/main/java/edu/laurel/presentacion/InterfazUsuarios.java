package edu.laurel.presentacion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.dominio.Usuario;
import edu.laurel.dominio.error.NombreUsuarioExistente;
import edu.laurel.frontera.EntradaUsuario;

@Named
@ViewScoped
public class InterfazUsuarios implements Serializable {

    private static final long serialVersionUID = 5040808907010877213L;

    @Inject
    EntradaUsuario entradaUsuario;

    private Usuario usuario;

    public Usuario getUsuario() {
	return usuario;
    }

    @PostConstruct
    public void inicio() {
	usuario = new Usuario();
    }

    public void alta() {
	try {
	    entradaUsuario.alta(usuario);
	    final FacesMessage facesMessage = new FacesMessage("Usuario " + usuario.getUsuario() + " creado.");
	    FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	    inicio();
	} catch (final NombreUsuarioExistente e) {
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
