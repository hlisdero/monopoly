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
	public void cantidadPropiedad()
	{
		Jugador jugador = new Jugador(new Casilla());
		Propiedad prop = new Propiedad(95000);
		
		jugador.addPropiedad(prop);
		int cantidad = jugador.cantidadPropiedad();
		
		assertEquals(cantidad, 1);
	}
	
	@Test
	public void addPropiedadRestaDinero() {
		Jugador jugador = new Jugador(new Casilla());
		Propiedad prop = new Propiedad(95000);
		assertEquals(100000, jugador.getCapital(), DELTA);
		jugador.addPropiedad(prop);
		assertEquals(5000, jugador.getCapital(), DELTA);
	}
}
