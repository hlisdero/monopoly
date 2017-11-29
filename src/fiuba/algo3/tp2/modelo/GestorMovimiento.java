package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorMovimiento {
	private ArrayList<ContadorTurnos> contadoresTurnos = new ArrayList<ContadorTurnos>();
	private Tablero tablero = new Tablero(this);
	
	public Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}

	public void agregarContadorTurnos(ContadorTurnos contador) {
		contadoresTurnos.add(contador);
	}
	
	public void notificarNuevoTurno(Jugador jugador) {
		for (ContadorTurnos elementoANotificar : contadoresTurnos) {
			elementoANotificar.contarTurno(jugador);
        }
	}

	public void mover(Jugador jugador) {
		this.mover(jugador, jugador.tirarDados().getSuma());
	}
	
	public void mover(Jugador jugador, int posiciones) {
		if (!jugador.sePuedeMover()) {
			return;
		} 
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		jugador.setCasilla(casillaSiguiente);
		casillaSiguiente.aplicarEfecto(jugador);
	}
	
	public void mover(Jugador jugador, Casilla casilla) {
		casilla.aplicarEfecto(jugador);
		jugador.setCasilla(casilla);
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public ArrayList<Casilla> getCasillas() {
		return tablero.getCasillas();
	}
}
