package edu.laurel.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.laurel.constantes.Prioridad;
import edu.laurel.dominio.Item;
import edu.laurel.dominio.Proyecto;
import edu.laurel.dominio.TipoItem;
import edu.laurel.dominio.Usuario;

public class ProyectoTest {
    private Proyecto proyecto;
    private Usuario lider;
    private TipoItem bug, requirement, change;

    @Before
    public void setUp() throws Exception {
	proyecto = new Proyecto("Parque-Siebel", lider);
	bug = new TipoItem("Reporte de Bug");
	requirement = new TipoItem("Requerimiento");
	change = new TipoItem("Requerimiento");

    }

    @After
    public void tearDown() throws Exception {
	proyecto = null;
    }

    @Test
    public void testAltaItem() {

	final Item item = new Item(bug, Prioridad.BAJA);
	proyecto.darAltaItem(item);

	assertTrue(proyecto.getItems().contains(item));

    }

    @Test
    public void testAltaTipoItem() {

	proyecto.darAltaTipoItem(bug);
	proyecto.darAltaTipoItem(requirement);
	proyecto.darAltaTipoItem(change);

	assertTrue(proyecto.getTipoItems().contains(bug));
	assertTrue(proyecto.getTipoItems().contains(requirement));
	assertTrue(proyecto.getTipoItems().contains(change));

    }
}
