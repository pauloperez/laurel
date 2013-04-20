package edu.laurel;

import static org.junit.Assert.*;

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
		Usuario usuario = new Usuario("Usuario Prueba");

		laurel.addUsuario(usuario);
		assertTrue(laurel.exist(usuario));

		laurel.removeUsuario(usuario);
		assertFalse(laurel.exist(usuario));
	}
}
