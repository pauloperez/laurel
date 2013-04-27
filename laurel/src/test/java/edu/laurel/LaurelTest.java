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
		assertTrue(laurel.estaRegistrado(usuario));
		assertTrue(usuario.esMiembro(Equipo.CALIDAD));
		assertFalse(usuario.esMiembro(Equipo.OPERACIONES));

		laurel.darBaja(usuario);
		assertFalse(laurel.estaRegistrado(usuario));
	}
}
