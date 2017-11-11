package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {
	private static final double DELTA = 1e-15;

	@Test
	public void jugadorNuevoNoNull() {
		assertNotNull(new Jugador(new CasillaPrueba()));
	}
	
	@Test
	public void capitalInicialCienMil() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		assertEquals(100000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void getCasillaDevuelveCasilla() {
		CasillaPrueba casilla = new CasillaPrueba();
		Jugador jugador = new Jugador(casilla);
		assertEquals(casilla, jugador.getCasilla());
	}
	
	@Test
	public void agregarDineroAumentaCapital() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		jugador.agregarDinero(50000);
		assertEquals(150000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void restarDineroDisminuyeCapital() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		try {
			jugador.restarDinero(50000);
		} catch (CapitalInsuficienteException e) {}
		assertEquals(50000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void tirarDadosDevuelveResultadoDados() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		assertNotNull(jugador.tirarDados());
	}
	
	@Test
	public void getResultadoDadosDevuelveResultadoDados() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		jugador.tirarDados();
		assertNotNull(jugador.getResultadoDados());
	}
}
