package edu.laurel.presentacion;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.dominio.NombreUsuarioExistenteExcepcion;
import edu.laurel.dominio.Usuario;
import edu.laurel.frontera.EntradaUsuario;

@Named
@ViewScoped
public class InterfazUsuarios implements Serializable {

	private static final long serialVersionUID = 5040808907010877213L;

	@Inject
	EntradaUsuario entradaUsuario;

	private String nombreUsuario, password;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(final String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	@PostConstruct
	public void inicio() {
		//nombreUsuario = "prueba";
	}

	public void alta() {

		final Usuario usuario = new Usuario(nombreUsuario, password);
		try {
			entradaUsuario.alta(usuario);
		} catch (final NombreUsuarioExistenteExcepcion e) {
			final FacesMessage facesMessage = new FacesMessage("Nombre de usuario ya existe!");
			FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);
		}
	}

	public void validarNombreUsuario() {
		if (entradaUsuario.estaInscripto(nombreUsuario)) {
			final FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nombre de usuario ya existe!", "");
			FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);
		}
	}
}
