package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasillaTest {

	@Test
	public void nuevoCasillaNoEsNull() {
		assertNotNull(new Casilla());
	}
	
	@Test
	public void aplicarEfectoNoHaceNada() {
		Casilla casilla = new Casilla();
		casilla.aplicarEfecto(null);
	}
	
	@Test
	public void casillaNoTieneNombreInicial() {
		Casilla casilla = new Casilla();
		assertNull(casilla.getNombreCasilla());
	}
	
	@Test
	public void getNombreCasillaDevuelveNombreCasilla() {
		Casilla casilla = new Casilla();
		
		casilla.setNombreCasilla("Salida");
		assertEquals("Salida", casilla.getNombreCasilla());
	}
	
	@Test
	public void setNombreCasillaCambiaNombreCasilla() {
		Casilla casilla = new Casilla();
		
		casilla.setNombreCasilla("Salida");
		casilla.setNombreCasilla("Llegada");
		assertEquals("Llegada", casilla.getNombreCasilla());
	}

}
