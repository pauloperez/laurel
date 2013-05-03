package edu.laurel;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TipoItemTest {
	private TipoItem tipoItem;

	@Before
	public void setUp() throws Exception {
		tipoItem = new TipoItem("Reporte de Bug");
	}

	@After
	public void tearDown() throws Exception {
		tipoItem = null;
	}

	@Test
	public void testAltaEstados() {
		final EstadoItem creado = new EstadoItem("Creado");
		final EstadoItem analisis = new EstadoItem("Analisis");
		final EstadoItem desarrollo = new EstadoItem("Desarrollo");
		final EstadoItem validacion = new EstadoItem("Validacion");

		tipoItem.agregarSecuencia(creado, desarrollo);

		tipoItem.agregarSecuencia(desarrollo, validacion);
		tipoItem.agregarSecuencia(validacion, new EstadoItem("Terminado"));
		tipoItem.agregarSecuencia(validacion, desarrollo);

		assertTrue(tipoItem.tieneConfigurado(validacion));
		assertFalse(tipoItem.tieneConfigurado(analisis));

		assertTrue(tipoItem.puedeRealizarSecuencia(validacion, desarrollo));
		assertFalse(tipoItem.puedeRealizarSecuencia(creado, validacion));
	}
}
