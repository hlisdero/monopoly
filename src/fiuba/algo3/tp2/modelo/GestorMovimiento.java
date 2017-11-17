package fiuba.algo3.tp2.modelo;

public class GestorMovimiento {
	private Tablero tablero = new Tablero(this);

	public Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	public void mover(Jugador jugador) {
		this.mover(jugador, jugador.tirarDados().getSuma());
	}
	
	public void mover(Jugador jugador, int posiciones) {
		if (jugador.noSePuedeMover()) {
			return;
		} 
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		casillaSiguiente.aplicarEfecto(jugador);
		jugador.setCasilla(casillaSiguiente);
	}	
}
