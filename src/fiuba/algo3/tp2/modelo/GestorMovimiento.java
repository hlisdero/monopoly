package fiuba.algo3.tp2.modelo;

class GestorMovimiento {
	private Tablero tablero = new Tablero(this);

	Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	void mover(Jugador jugador) {
		this.mover(jugador, jugador.tirarDados().getSuma());
	}
	
	void mover(Jugador jugador, int posiciones) {
		if (jugador.noSePuedeMover()) {
			return;
		} 
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		casillaSiguiente.aplicarEfecto(jugador);
		jugador.setCasilla(casillaSiguiente);
	}
	
}
