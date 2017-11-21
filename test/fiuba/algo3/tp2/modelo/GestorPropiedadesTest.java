package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorPropiedadesTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorPropiedades());
	}
	
	@Test
	public void nuevoGestorEstaVacio() {
		GestorPropiedades gestor = new GestorPropiedades();
		assertEquals(gestor.getCantidadPropiedades(),0);
	}
	
	@Test
	public void agregarPropiedadAgregaALaLista() {
		GestorPropiedades gestor = new GestorPropiedades();
		Propiedad prop = new Propiedad(100,0);
		gestor.agregarPropiedad(prop);
		assertEquals(gestor.getCantidadPropiedades(),1);
	}
	
	@Test
	public void quitarPropiedadLaQuitaDeLaLista() {
		GestorPropiedades gestor = new GestorPropiedades();
		Propiedad prop = new Propiedad(100,0);
		gestor.agregarPropiedad(prop);
		gestor.quitarPropiedad(prop);
		assertEquals(gestor.getCantidadPropiedades(),0);
	}

}
