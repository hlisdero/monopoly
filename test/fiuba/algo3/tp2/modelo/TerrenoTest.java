package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TerrenoTest {
	@Test
	public void test01TerrenoAsignarDueno() {
		Jugador jugador1 = new Jugador();
		Terreno terreno1 = new Terreno(200);
		terreno1.asignarDueno(jugador1);
		assertEquals(terreno1.duenoDelTerreno(),jugador1);
			
	}
}
