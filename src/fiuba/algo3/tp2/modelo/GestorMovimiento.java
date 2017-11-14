package fiuba.algo3.tp2.modelo;

class GestorMovimiento {
	private Tablero tablero = new Tablero();
	private Carcel carcel = new Carcel();
	
	GestorMovimiento() {
		tablero.insertarCasilla(5, carcel);
	}
	
	Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	void mover(Jugador jugador) {
		if (carcel.estaAdentro(jugador)) {
			jugador.getCasilla().aplicarEfecto(jugador);
			return;
		} else {
			Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
			casillaSiguiente.aplicarEfecto(jugador);
			jugador.setCasilla(casillaSiguiente);
		}
	}
	
}
