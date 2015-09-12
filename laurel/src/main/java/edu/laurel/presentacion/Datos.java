package edu.laurel.presentacion;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import edu.laurel.constantes.Equipo;

@Named
@ApplicationScoped
public class Datos implements Serializable {

	private static final long serialVersionUID = 5040808907010877213L;

	public Equipo[] getEquipos() {
		return Equipo.values();
	}
}
