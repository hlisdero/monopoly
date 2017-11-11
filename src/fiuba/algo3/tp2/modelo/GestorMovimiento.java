package fiuba.algo3.tp2.modelo;

class GestorMovimiento {
	private Tablero tablero = new Tablero();
	
	Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	void mover(Jugador jugador) {
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
		casillaSiguiente.aplicarEfecto(jugador);
		jugador.setCasilla(casillaSiguiente);
	}
	
}
