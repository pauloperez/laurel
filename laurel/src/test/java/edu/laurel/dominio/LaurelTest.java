package edu.laurel.dominio;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import edu.laurel.constantes.Equipo;
import edu.laurel.dominio.error.NombreProyectoExistente;
import edu.laurel.dominio.error.NombreUsuarioExistente;
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
    public void testAltaUsuario() throws NombreUsuarioExistente {
	final Usuario usuario = new Usuario();
	final String nombre = "Usuario Prueba";
	usuario.setNombre(nombre);
	usuario.setUsuario("prueba");
	usuario.setPassword("Contraseña");
	final Set<Equipo> equipos = usuario.getEquipos();
	equipos.add(Equipo.CALIDAD);
	usuario.setEquipos(equipos);

	laurel.darAlta(usuario);
	assertTrue(laurel.estaInscripto(nombre));
	assertTrue(usuario.esMiembro(Equipo.CALIDAD));
	assertFalse(usuario.esMiembro(Equipo.OPERACIONES));

	laurel.darBaja(usuario);
	assertFalse(laurel.estaInscripto(nombre));
    }

    @Test
    public void testRegistroProyectos() throws NombreProyectoExistente {
	final Usuario lider = new Usuario();
	final String nombre = "Proyecto Prueba";
	final Proyecto proyecto = new Proyecto(nombre, lider);

	laurel.registrar(proyecto);
	assertTrue(laurel.estaRegistrado(nombre));

	laurel.borrar(proyecto);
	assertFalse(laurel.estaRegistrado(nombre));
    }
}
