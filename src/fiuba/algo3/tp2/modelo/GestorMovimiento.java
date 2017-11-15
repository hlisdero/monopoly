package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class GestorMovimiento {
	private Tablero tablero = new Tablero();
	private Carcel carcel = new Carcel();
	private MovimientoDinamico avance = new MovimientoDinamico(new Avance());
	private MovimientoDinamico retroceso = new MovimientoDinamico(new Retroceso());
	private  ArrayList<Casilla> casillerosProhibidos = new ArrayList<Casilla>();
	GestorMovimiento() {
		tablero.insertarCasilla(5, carcel);
		tablero.insertarCasilla(7, avance);
		tablero.insertarCasilla(18, retroceso);
		this.casillerosProhibidos.add(avance);
		this.casillerosProhibidos.add(retroceso);
	}
	
	Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	void mover(Jugador jugador) {
		if (carcel.estaAdentro(jugador)) {
			jugador.getCasilla().aplicarEfecto(jugador);
			return;
		} else {
			Casilla casillaSiguiente;
			do {
				casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
				casillaSiguiente.aplicarEfecto(jugador);
				jugador.setCasilla(casillaSiguiente);
			}while(casillerosProhibidos.contains(casillaSiguiente));
		}
	}
	
}
