package fiuba.algo3.tp2.vista;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;

import fiuba.algo3.tp2.controlador.AlgoPoly;


public class TerrenoVistaTest {
		@Rule 
		public JavaFXThreadingRule javafxRule = new JavaFXThreadingRule();
		@Test
		public void nuevoTerrenoVistaNoEsNull() {
			TerrenoVista terreno = new TerrenoVista();
			assertNotNull(terreno);
		}

		@Test
		public void getControladorDevuelveAlgoPoly() {
			TerrenoVista terreno = new TerrenoVista();
			AlgoPoly poly = terreno.getControlador();
			assertNotNull(poly);
		}
		
		@Test
		public void getCasillasVistaNoDevuelveNull(){
			//Devuelve una lista
			TerrenoVista terreno = new TerrenoVista();
			assertNotNull(terreno.getCasillasVista());
		}
		
		@Test
		public void getCasillaVistaNoDevuelveNull(){
			TerrenoVista terreno = new TerrenoVista();
			assertNotNull(terreno.getCasillaVista(1));
		}
		
		@Test
		public void crearHotelVistaLoAgregaAlTerreno() {
			TerrenoVista terreno = new TerrenoVista();
			int tam = terreno.getChildrenUnmodifiable().size();
			terreno.crearHotelVista(10.0,10.0,terreno.getCasillaVista(1));
			assertEquals(tam + 1,terreno.getChildrenUnmodifiable().size());
			
		}

}
