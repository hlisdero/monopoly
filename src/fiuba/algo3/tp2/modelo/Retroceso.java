package fiuba.algo3.tp2.modelo;

public class Retroceso implements TipoMovimiento {
	
	public int getIndiceMovimiento(Jugador jugador) {
		int sumaDados = jugador.getResultadoDados().getSuma();
		if (sumaDados <= 6) {
			return this.efectoPrimero(jugador);
		} else if (sumaDados <= 10) {
			return this.efectoSegundo(jugador);
		} else {
			return this.efectoTercero(jugador); 
		}
	}
	
	private int efectoPrimero(Jugador jugador) {
		return -jugador.getResultadoDados().getSuma() + jugador.getCantidadPropiedades();
	}
	
	private int efectoSegundo(Jugador jugador) {
		return -(int) ((jugador.getCapital()) % (jugador.getResultadoDados().getSuma()));
	}
	
	private int efectoTercero(Jugador jugador) {
		return -jugador.getResultadoDados().getSuma() + 2;
	}
}
