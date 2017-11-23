package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorPropiedadesTest {
	
	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorPropiedades(new Jugador(new Casilla())));
	}
	
	@Test
	public void nuevoGestorEstaVacio() {
		GestorPropiedades gestor = new GestorPropiedades(new Jugador(new Casilla()));
		assertEquals(gestor.getCantidadPropiedades(),0);
	}
	
	@Test
	public void comprarAumentaCantidadPropiedades() {
		GestorPropiedades gestor = new GestorPropiedades(new Jugador(new Casilla()));
		Propiedad propiedad = new Propiedad(0);
		
		gestor.comprar(propiedad);
		assertEquals(gestor.getCantidadPropiedades(),1);
	}
	
	@Test
	public void venderDisminuyeCantidadPropiedades() {
		GestorPropiedades gestor = new GestorPropiedades(new Jugador(new Casilla()));
		Propiedad prop = new Propiedad(0);
		
		gestor.comprar(prop);
		gestor.vender(prop);
		assertEquals(0, gestor.getCantidadPropiedades());
	}
}
