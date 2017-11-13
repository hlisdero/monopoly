package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Tablero {
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	private int cantidadCasillas = 20;
	
	Tablero() {
		int i;
		for (i = 0; i < cantidadCasillas; i++) {
			casillas.add(new Casilla());
		}
	}
	
	Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	Casilla getCasillaSiguiente(Casilla casillaActual, ResultadoDados dados) {
		int posicionCasillaActual = casillas.indexOf(casillaActual);
		return casillas.get(casillaActual.getIndiceCasillaSiguiente(posicionCasillaActual, dados) % cantidadCasillas);
	}
}
