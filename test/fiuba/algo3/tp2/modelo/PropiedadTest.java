package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;




public class PropiedadTest {
	
	@Test
	public void propiedadSeCreaYNoTieneDuenio() {
		Propiedad propiedad = new Propiedad(1000);
		assertTrue(propiedad.noTienePropietario());
		
	}
	
	@Test
	public void propiedadTieneDuenio() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(new Casilla());
		propiedad.setPropietario(jugador);
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void propiedadVendidaPorDuenio() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador1 = new Jugador(new Casilla());
		propiedad.setPropietario(jugador1);
		propiedad.jugadorVendePropiedad(jugador1);
		assertTrue(propiedad.noTienePropietario());
	}



}
