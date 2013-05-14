package edu.laurel;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ProyectoTest {
	private Proyecto proyecto;
	private Usuario lider;

	@Before
	public void setUp() throws Exception {
		proyecto = new Proyecto("Parque-Siebel", lider);

	}

	@After
	public void tearDown() throws Exception {
		proyecto = null;
	}

	@Test
	public void testAltaItem() {

		final TipoItem tipoItem = new TipoItem("Reporte de Bug");
		final Item item = new Item(tipoItem, Prioridad.BAJA);

		proyecto.darAltaItem(item);

		assertTrue(proyecto.getItems().contains(item));
	}
}
