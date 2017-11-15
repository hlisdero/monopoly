package fiuba.algo3.tp2.modelo;

class GestorMovimiento {
	private Tablero tablero = new Tablero();

	Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	void mover(Jugador jugador) {
		if (tablero.getCarcel().estaAdentro(jugador)) {
			jugador.getCasilla().aplicarEfecto(jugador);
			return;
		} 
		Casilla casillaSiguiente;
		do {
			casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
			casillaSiguiente.aplicarEfecto(jugador);
			jugador.setCasilla(casillaSiguiente);
		} while(tablero.esCasilleroProhibido(casillaSiguiente));
	}
	
}
