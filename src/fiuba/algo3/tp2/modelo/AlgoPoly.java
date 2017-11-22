package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	private GestorMovimiento gestorMovimiento = new GestorMovimiento();
	private GestorTurnos gestorTurnos = new GestorTurnos(gestorMovimiento.getCasillaInicial());
	
	public void mover() {
		Jugador jugador = gestorTurnos.proximoJugador();
		gestorMovimiento.notificarNuevoTurno(jugador);
		gestorMovimiento.mover(jugador);
	}
}
