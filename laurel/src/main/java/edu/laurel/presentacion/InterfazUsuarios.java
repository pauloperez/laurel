package edu.laurel.presentacion;

import javax.inject.Inject;
import javax.inject.Named;

import edu.laurel.aplicacion.ServiciosUsuario;

@Named
public class InterfazUsuarios {

    @Inject
    ServiciosUsuario serviciosUsuario;

    public void altaUsuario() {

    }

}