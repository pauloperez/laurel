package edu.laurel.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.laurel.constantes.Prioridad;

public class ProyectoTest {
    private Proyecto proyecto;
    private Usuario lider;
    private EstadoItem creado, analisis, desarrollo, validacion;
    private TipoItem bug, requirement, change;

    @Before
    public void setUp() throws Exception {
	proyecto = new Proyecto("Parque-Siebel", lider);
	creado = new EstadoItem("Creado");
	analisis = new EstadoItem("Analisis");
	desarrollo = new EstadoItem("Desarrollo");
	validacion = new EstadoItem("Validacion");
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

	assertTrue(proyecto.getTiposItem().contains(bug));
	assertTrue(proyecto.getTiposItem().contains(requirement));
	assertTrue(proyecto.getTiposItem().contains(change));
    }

    @Test
    public void testAltaEstadoItem() {
	proyecto.setEstadosItem(creado, analisis, desarrollo, validacion);

	assertTrue(proyecto.getEstadosItem().contains(creado));
	assertTrue(proyecto.getEstadosItem().contains(analisis));
	assertTrue(proyecto.getEstadosItem().contains(desarrollo));
	assertTrue(proyecto.getEstadosItem().contains(validacion));

    }
}
