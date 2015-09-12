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

	private String nombre, usuarioString, password;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuarioString;
	}

	public void setUsuario(final String usuario) {
		usuarioString = usuario;
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

		final Usuario usuario = new Usuario(nombre, usuarioString, password);
		try {
			entradaUsuario.alta(usuario);
		} catch (final NombreUsuarioExistenteExcepcion e) {
			final FacesMessage facesMessage = new FacesMessage("Nombre de usuario ya existe!");
			FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);
		}
	}

	public void validarNombreUsuario() {
		if (entradaUsuario.estaInscripto(usuarioString)) {
			final FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_WARN,
					"Nombre de usuario ya existe!", "");
			FacesContext.getCurrentInstance().addMessage("altaUsuario:usuario", facesMessage);
		}
	}
}
