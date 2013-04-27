package edu.laurel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LaurelTest {

	Laurel laurel;

	@Before
	public void setUp() throws Exception {
		laurel = new Laurel();
	}

	@After
	public void tearDown() throws Exception {
		laurel = null;
	}

	@Test
	public void testAltaUsuario() {
		final Usuario usuario = new Usuario("Usuario Prueba");
		usuario.asignar(Equipo.CALIDAD);

		laurel.darAlta(usuario);
		assertTrue(laurel.estaInscripto(usuario));
		assertTrue(usuario.esMiembro(Equipo.CALIDAD));
		assertFalse(usuario.esMiembro(Equipo.OPERACIONES));

		laurel.darBaja(usuario);
		assertFalse(laurel.estaInscripto(usuario));
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
