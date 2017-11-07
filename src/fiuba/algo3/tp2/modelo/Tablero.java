package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Tablero {
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	
	Tablero() {
		int i;
		for (i = 0; i < 20; i++) {
			casillas.add(new Casilla(i));
		}
	}
	
	Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	Casilla getCasillaSiguiente(Casilla casilla, int posiciones) {
		return casillas.get(casilla.siguiente(posiciones));
	}
}
