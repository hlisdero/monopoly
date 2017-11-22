package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorMovimiento {
	private ArrayList<ContadorTurnos> contadoresTurnos = new  ArrayList<ContadorTurnos>();
	private Tablero tablero = new Tablero(this);

	
	public Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	public void mover(Jugador jugador) {
		this.mover(jugador, jugador.tirarDados().getSuma());
	}
	
	public void notificarNuevoTurno(Jugador jugador) {
		for(int i = 0; i < contadoresTurnos.size(); i++){
			contadoresTurnos.get(i).contarTurno(jugador);;
        }
	}
	
	public void agregarContadorTurnos(ContadorTurnos contador) {
		contadoresTurnos.add(contador);
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
