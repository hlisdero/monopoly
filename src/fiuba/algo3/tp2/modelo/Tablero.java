package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Tablero {
	private ArrayList<Casilla> casilleros = new ArrayList<Casilla>();
	private int cantidadCasillas = 20;
	
	Tablero() {
		int i;
		for (i = 0; i < cantidadCasillas; i++) {
			casilleros.add(new CasillaPrueba());
		}
	}
	
	
	Casilla getCasillaInicial() {
		return casilleros.get(0);
	}
	
	Casilla getCasillaSiguiente(Casilla unaCasilla, ResultadoDados dados) {
		return casilleros.get((casilleros.indexOf(unaCasilla) + dados.getSuma()) % cantidadCasillas) ;
	}
}
