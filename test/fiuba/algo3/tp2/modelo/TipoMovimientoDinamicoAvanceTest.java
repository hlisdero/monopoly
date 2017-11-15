package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TipoMovimientoDinamicoAvanceTest {
	
	@Test
	public void efectosPrimeroAvance() {
		Avance avance = new Avance();
		Jugador jugador = new Jugador(new Casilla());
		assertEquals (avance.efectoPrimero(jugador),-2);
	}
	@Test
	public void efectosSegundoAvance() {
		Avance avance = new Avance();
		Jugador jugador = new Jugador(new Casilla());
		ResultadoDados ultimaTirada = jugador.tirarDados();
		assertEquals (avance.efectoSegundo(jugador),(int)jugador.getCapital() % ultimaTirada.getSuma());
	}
	public void efectosTercerAvance() {
		Avance avance = new Avance();
		Jugador jugador = new Jugador(new Casilla());
		assertEquals (avance.efectoPrimero(jugador),-jugador.cantidadPropiedad());
	}
}
