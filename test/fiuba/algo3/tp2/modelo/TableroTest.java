package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TableroTest {

	@Test
	public void nuevoTableroNoNull() {
		assertNotNull(new Tablero(new GestorMovimiento()));
	}
	
	@Test
	public void getCasillaInicialDevuelveCasillaInicial() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		assertNotNull(tablero.getCasillaInicial());
	}
	
	@Test
	public void getCasillasDevuelveCasillas() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		assertNotNull(tablero.getCasillas());
	}
	
	@Test
	public void getCasillasDevuelveArrayLongitudVeinte() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		assertEquals(20, tablero.getCasillas().size());
	}
	
	@Test
	public void getCasillaSiguienteDevuelveCasillaInicialSiPosicionesEsCero() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		Casilla casillaInicial = tablero.getCasillaInicial();
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(casillaInicial, 0);
		
		assertEquals(casillaInicial, casillaSiguiente);
	}
	
	@Test
	public void getCasillaSiguienteDevuelveCasillaInicialSiPosicionesEsVeinte() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		Casilla casillaInicial = tablero.getCasillaInicial();
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(casillaInicial, 20);
		
		assertEquals(casillaInicial, casillaSiguiente);
	}
	
	@Test
	public void getCasillaSiguienteDevuelveMismaCasillaSiPosicionesEsVeinte() {
		Tablero tablero = new Tablero(new GestorMovimiento());
		Casilla casillaInicial = tablero.getCasillaInicial();
		Casilla casillaSiguiente1 = tablero.getCasillaSiguiente(casillaInicial, 5);
		Casilla casillaSiguiente2 = tablero.getCasillaSiguiente(casillaSiguiente1, 20);
		
		assertEquals(casillaSiguiente1, casillaSiguiente2);
	}

}
