package edu.laurel.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import edu.laurel.Equipo;
import edu.laurel.Proyecto;
import edu.laurel.Usuario;
import edu.laurel.dominio.Laurel;
import edu.laurel.repositorios.RepositorioUsuarios;

@Ignore
public class LaurelTest {

    Laurel laurel;

    @Before
    public void setUp() throws Exception {
	laurel = new Laurel();
	laurel.repositorioUsuarios = mock(RepositorioUsuarios.class);
    }

    @After
    public void tearDown() throws Exception {
	laurel = null;
    }

    @Test
    public void testAltaUsuario() {
	final String nombre = "Usuario Prueba";
	final Usuario usuario = new Usuario(nombre);
	usuario.asignar(Equipo.CALIDAD);

	laurel.darAlta(usuario);
	assertTrue(laurel.estaInscripto(nombre));
	assertTrue(usuario.esMiembro(Equipo.CALIDAD));
	assertFalse(usuario.esMiembro(Equipo.OPERACIONES));

	laurel.darBaja(usuario);
	assertFalse(laurel.estaInscripto(nombre));
    }

    @Test
    public void testRegistroProyectos() {
	final Usuario lider = new Usuario("Usuario Prueba");
	final String nombre = "Proyecto Prueba";
	final Proyecto proyecto = new Proyecto(nombre, lider);

	laurel.registrar(proyecto);
	assertTrue(laurel.estaRegistrado(proyecto));

	laurel.borrar(proyecto);
	assertFalse(laurel.estaRegistrado(proyecto));
    }
}
