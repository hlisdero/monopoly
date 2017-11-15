package fiuba.algo3.tp2.modelo;

public class Retroceso implements TipoMovimiento {


	public int efectoPrimero (Jugador jugador) {
		return -jugador.cantidadPropiedad();
	}
	
	public int efectoSegundo (Jugador jugador) {
		return  (int) ((jugador.getCapital()) % (jugador.getResultadoDados().getSuma()));
	}
	
	public int efectoTercero (Jugador jugador) {
		return -2;
	}
}
