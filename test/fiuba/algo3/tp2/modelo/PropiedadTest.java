package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropiedadTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaPropiedadNoNull() {
		assertNotNull(new Propiedad(0));
	}

	@Test
	public void nuevaPropiedadNoTienePropietario() {
		Propiedad propiedad = new Propiedad(0);
		assertFalse(propiedad.tienePropietario());
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Propiedad propiedad = new Propiedad(1000);
		assertEquals(1000, propiedad.getPrecio(), DELTA);
	}
	
	@Test
	public void getPrecioVentaDevuelvePrecioMenosQuincePorciento() {
		Propiedad propiedad = new Propiedad(1000);
		assertEquals(1000 * 0.85, propiedad.getPrecioVenta(), DELTA);
	}
	
	@Test
	public void getPropietarioDevuelvePropietario() {
		Propiedad propiedad = new Propiedad(0);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.setPropietario(jugador);
		assertEquals(jugador, propiedad.getPropietario());		
	}
	
	@Test
	public void tienePropietarioDevuelveTrueSiTienePropietario() {
		Propiedad propiedad = new Propiedad(0);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.setPropietario(jugador);
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void setPropietarioCambiaPropietario() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(new Casilla());
		
		propiedad.setPropietario(jugador);
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void comprarCambiaPropietario() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.comprar(jugador);
		assertTrue(propiedad.tienePropietario());
	}
	
	@Test
	public void comprarRestaPrecioCapitalPropietario() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.comprar(jugador);
		assertEquals(100000 - 1000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void venderCambiaPropietario() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.setPropietario(jugador);
		propiedad.vender(jugador);
		assertFalse(propiedad.tienePropietario());
	}
	
	@Test
	public void venderAgregaPrecioVentaCapitalPropietario() {
		Propiedad propiedad = new Propiedad(1000);
		Jugador jugador = new Jugador(propiedad);
		
		propiedad.setPropietario(jugador);
		propiedad.vender(jugador);
		assertEquals(100000 + 850, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void debeCobrarDevuelveFalseSiNoHayPropietario() {
		Propiedad propiedad = new Propiedad(0);
		Jugador jugador = new Jugador(propiedad);

		assertFalse(propiedad.debeCobrar(jugador));
	}
	
	@Test
	public void debeCobrarDevuelveFalseSiJugadorPropietario() {
		Propiedad propiedad = new Propiedad(0);
		Jugador jugador = new Jugador(propiedad);

		propiedad.setPropietario(jugador);
		assertFalse(propiedad.debeCobrar(jugador));
	}
	
	@Test
	public void debeCobrarDevuelveTrueSiJugadorNoPropietario() {
		Propiedad propiedad = new Propiedad(0);
		Jugador propietario = new Jugador(propiedad);
		Jugador visitante = new Jugador(propiedad);

		propiedad.setPropietario(propietario);
		assertTrue(propiedad.debeCobrar(visitante));
	}
}
