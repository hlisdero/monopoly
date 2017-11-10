package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropiedadTest {

	@Test
	public void jugadorSeAdueniaDeLaPropiedad() throws CapitalInsuficienteException {
		
		Propiedad santaFe = new Propiedad(15000);
		Jugador jugador = new Jugador(santaFe);
		
		int capital = jugador.restarDinero(santaFe.getPrecioDelTerreno());
		jugador.addTerrenoALaLista(santaFe);
		santaFe.asignarDuenio(jugador);
		
		assertEquals(capital, 85000);
		assertEquals(jugador, santaFe.duenioDelTerreno());
		
	}

}
