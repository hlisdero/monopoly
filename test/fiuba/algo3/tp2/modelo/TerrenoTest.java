package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TerrenoTest {
	@Test
	public void test01TerrenoAsignarDueno() {
		Jugador jugador0 = new Jugador();
		Terreno terreno1 = new Terreno(200);
		terreno1.asignarDuenio(jugador0);
		assertEquals(terreno1.duenioDelTerreno(),jugador0);
			
	}
}
