package edu.laurel.frontera;

import java.io.Serializable;

import javax.inject.Inject;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

import edu.laurel.dominio.Laurel;
import edu.laurel.dominio.Usuario;
import edu.laurel.dominio.error.NombreUsuarioExistente;
import edu.laurel.repositorios.Raiz;

public class EntradaUsuario implements Serializable {

    private static final long serialVersionUID = 5735209983740584036L;

    @Inject
    @Raiz
    private Laurel laurel;

    @Transactional
    public void alta(final Usuario usuario) throws NombreUsuarioExistente {
	laurel.darAlta(usuario);
    }

    @Transactional
    public void baja(final Usuario usuario) {
	laurel.darBaja(usuario);
    }

    public boolean estaInscripto(final String nombreUsuario) {
	return laurel.estaInscripto(nombreUsuario);
    }

    public Usuario buscar(final int oid) {
	return laurel.buscarUsuario(oid);
    }
}
