package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Tablero {
	private static final int CANTIDAD_CASILLAS = 20;
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	
	public Tablero(GestorMovimiento gestor) {
		
		/* Creación de las empresas */
		Empresa edesur = new Empresa(35000, 500,1000,"EDESUR");
		Empresa subte = new Empresa(40000, 600,1100, "SUBTE");
		Empresa aysa = new Empresa(30000, 300,500,"AYSA");
		Empresa trenes = new Empresa(38000, 450,800,"TRENES");
		
		/* Creación de las provincias dobles, las que tienen dos partes */
		Provincia buenosAiresSur = new Provincia(20000, 2000, 5000, 8000, 3000, 3500, 5000, "BA ZONA SUR");
		Provincia buenosAiresNorte = new Provincia(25000, 2500, 5500, 9000, 3500, 4000, 6000, "BA ZONA NORTE");
		Provincia cordobaSur = new Provincia(18000, 1000, 2000, 3000, 1500, 2500, 3000, "CORDOBA ZONA SUR");
		Provincia cordobaNorte = new Provincia(20000, 1300, 2200, 3500, 1800, 2900, 3500, "CORDOBA ZONA NORTE");
		Provincia saltaNorte = new Provincia(23000, 2000, 4500, 7500, 3250, 3850, 5500, "SALTA ZONA NORTE");
		Provincia saltaSur = new Provincia(23000, 2000, 4500, 7500, 3250, 3850, 5500, "SALTA ZONA SUR");
		
		/* Creación de las provincias simples, las que tienen una única parte */
		Provincia santaFe = new Provincia(15000, 1500, 4000, 3500, "SANTA FE");
		Provincia neuquen = new Provincia(17000, 1800, 4800, 3800, "NEUQUEN");
		Provincia tucuman = new Provincia(25000, 2500, 7000, 2500, "TUCUMAN");
		
		/* Creación de la casilla cárcel */
		Carcel carcel = new Carcel();
		
		/* Creación de las casillas de movimiento dinámico */
		CasillaMovimientoDinamico avance = new CasillaMovimientoDinamico(new Avance(), gestor, "AVANCE");
		CasillaMovimientoDinamico retroceso = new CasillaMovimientoDinamico(new Retroceso(), gestor, "RETROCESO");
		
		/* Agrego las casillas en orden */
		casillas.add(new Casilla());					// Salida
		casillas.add(new Quini());						// Quini 6
		casillas.add(buenosAiresSur);					// Buenos Aires Zona Sur
		casillas.add(edesur);							// EDESUR
		casillas.add(buenosAiresNorte);					// Buenos Aires Zona Norte	
		casillas.add(carcel);							// Cárcel
		casillas.add(cordobaSur);						// Córdoba Zona Sur
		casillas.add(avance);							// Avance Dinámico		
		casillas.add(subte);							// Subte
		casillas.add(cordobaNorte);						// Córdoba Zona Norte
		casillas.add(new Impuesto());					// Impuesto al Lujo
		casillas.add(santaFe);							// Santa Fe
		casillas.add(aysa);								// AYSA
		casillas.add(saltaNorte);						// Salta Zona Norte
		casillas.add(saltaSur);							// Salta Zona Sur
		casillas.add(new Policia(carcel, gestor));		// Policia
		casillas.add(trenes);							// Trenes
		casillas.add(neuquen);							// Neuquén
		casillas.add(retroceso);						// Retroceso Dinámico
		casillas.add(tucuman);							// Tucumán

		/* Configuración de las provincias dobles */
		buenosAiresSur.setProvinciaHermana(buenosAiresNorte);
		buenosAiresNorte.setProvinciaHermana(buenosAiresSur);
		cordobaSur.setProvinciaHermana(cordobaNorte);
		cordobaNorte.setProvinciaHermana(cordobaSur);
		saltaSur.setProvinciaHermana(saltaNorte);
		saltaNorte.setProvinciaHermana(saltaSur);
		
		/* Configuración extra de las casillas especiales */
		gestor.agregarContadorTurnos(carcel);
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);
		subte.setEmpresaHermana(trenes);
		trenes.setEmpresaHermana(subte);
	}

	public Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	public Casilla getCasillaSiguiente(Casilla casillaActual, int posiciones) {		
		int posicionCasillaSiguiente = (casillas.indexOf(casillaActual) + posiciones) % CANTIDAD_CASILLAS;
		return casillas.get(posicionCasillaSiguiente);
	}

	public ArrayList<Casilla> getCasillas() {
		return casillas;
	}
	
}
