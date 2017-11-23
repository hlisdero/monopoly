package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {
	private static final double DELTA = 1e-15;

	@Test
	public void jugadorNuevoNoNull() {
		assertNotNull(new Jugador(new Casilla()));
	}
	
	@Test
	public void capitalInicialCienMil() {
		Jugador jugador = new Jugador(new Casilla());
		assertEquals(100000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void cantidadPropiedaddesInicialCero() {
		Jugador jugador = new Jugador(new Casilla());
		assertEquals(0, jugador.getCantidadPropiedades());
	}
	
	@Test
	public void getResultadoDadosInicialAntesTirarDadosDevuelveNull() {
		Jugador jugador = new Jugador(new Casilla());
		assertEquals(null, jugador.getResultadoDados());
	}
	
	@Test
	public void getCasillaDevuelveCasilla() {
		Casilla casilla = new Casilla();
		Jugador jugador = new Jugador(casilla);
		assertEquals(casilla, jugador.getCasilla());
	}
	
	@Test
	public void agregarDineroAumentaCapital() {
		Jugador jugador = new Jugador(new Casilla());
		jugador.agregarDinero(50000);
		assertEquals(150000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void restarDineroDisminuyeCapital() {
		Jugador jugador = new Jugador(new Casilla());
		try {
			jugador.restarDinero(50000);
		} catch (CapitalInsuficienteException e) {}
		assertEquals(50000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void tirarDadosDevuelveResultadoDados() {
		Jugador jugador = new Jugador(new Casilla());
		assertNotNull(jugador.tirarDados());
	}
	
	@Test
	public void getResultadoDadosDevuelveResultadoDados() {
		Jugador jugador = new Jugador(new Casilla());
		jugador.tirarDados();
		assertNotNull(jugador.getResultadoDados());
	}
	
	@Test
	public void agregarPropiedadAumentaCantidadPropiedades() {
		Jugador jugador = new Jugador(new Casilla());
		Propiedad propiedad = new Propiedad(1000);
		
		jugador.comprar(propiedad);
		assertEquals(1, jugador.getCantidadPropiedades());
	}
	
}
