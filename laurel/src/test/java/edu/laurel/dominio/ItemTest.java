package edu.laurel.dominio;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.laurel.dominio.EstadoItem;
import edu.laurel.dominio.Item;
import edu.laurel.dominio.TipoItem;

public class ItemTest {

    private EstadoItem creado, desarrollo, validacion, terminado;
    private Item item;

    @Before
    public void setUp() throws Exception {
	creado = new EstadoItem("Creado");
	desarrollo = new EstadoItem("Desarrollo");
	validacion = new EstadoItem("Validacion");
	terminado = new EstadoItem("Terminado");

	final TipoItem tipoItem = new TipoItem("Reporte de Bug");
	tipoItem.agregarSecuencia(creado, desarrollo);
	tipoItem.agregarSecuencia(desarrollo, validacion);
	tipoItem.agregarSecuencia(validacion, terminado);
	tipoItem.agregarSecuencia(validacion, desarrollo);

	item = new Item(tipoItem);
    }

    @After
    public void tearDown() throws Exception {
	item = null;
    }

    @Test
    public void testCambiarEstadoItem() {
	assertTrue(item.getCamino().isEmpty());
	item.pasarA(creado);
	assertSame(creado, item.verEstadoActual());
	item.pasarA(desarrollo);
	assertSame(desarrollo, item.verEstadoActual());
	item.pasarA(validacion);
	assertSame(validacion, item.verEstadoActual());
	item.pasarA(desarrollo);
	assertSame(desarrollo, item.verEstadoActual());
	item.pasarA(validacion);
	assertSame(validacion, item.verEstadoActual());
	item.pasarA(terminado);
	assertSame(terminado, item.verEstadoActual());
    }

    @Test
    public void testVerHistorico() {
	testCambiarEstadoItem();

	assertSame(terminado, item.getCamino().pop());
	assertSame(validacion, item.getCamino().pop());
	assertSame(desarrollo, item.getCamino().pop());
	assertSame(validacion, item.getCamino().pop());
	assertSame(desarrollo, item.getCamino().pop());
	assertSame(creado, item.getCamino().pop());
	assertTrue(item.getCamino().isEmpty());
    }
}