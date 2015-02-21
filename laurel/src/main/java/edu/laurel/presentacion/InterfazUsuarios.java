package edu.laurel.presentacion;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.aplicacion.ServiciosUsuario;
import edu.laurel.dominio.Usuario;

@Named
@ViewScoped
public class InterfazUsuarios {

	@Inject
	ServiciosUsuario serviciosUsuario;

	private String nombreUsuario;

	@PostConstruct
	public void inicio() {
		nombreUsuario = "Un nombre cualquiera";
	}

	public void alta() {
		final Usuario usuario = new Usuario(nombreUsuario);
		serviciosUsuario.alta(usuario);
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(final String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
