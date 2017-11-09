package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class JugadorTest {

	@Test
	public void test01CantidadDeCasilla() {
		Jugador jugador1 = new Jugador();
		assertEquals(jugador1.getListaDeCasillasDelJugador().size(),0);
		
		Casilla unaCasilla = new Casilla();
		jugador1.addTerrenoALaLista(unaCasilla);
		assertEquals(jugador1.getListaDeCasillasDelJugador().size(),1);
		
	}
	
	@Test
	public void test02JugadorCompraUnTerreno() throws CapitalInsuficienteException
	{
		AlgoPoly algo = new AlgoPoly();
		Jugador jugador = new Jugador();
		Terreno unTerreno = new Terreno(20000);
		
		int monto = algo.jugadorCompraTerreno(jugador, unTerreno);
		
		assertEquals(monto, 80000);
	}

	@Test
	public void test03JugadorCompraUnaCompania() throws CapitalInsuficienteException
	{
		AlgoPoly algo = new AlgoPoly();
		Jugador jugador = new Jugador();
		Compania unaCompania = new Compania(35000);
		
		int monto = algo.jugadorCompraCompania(jugador, unaCompania);
		
		assertEquals(monto, 65000);
	}
}
