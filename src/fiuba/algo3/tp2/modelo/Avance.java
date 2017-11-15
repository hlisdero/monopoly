package fiuba.algo3.tp2.modelo;

public class Avance implements TipoMovimiento{
	
	public int efectoPrimero (Jugador jugador) {
		return -2;
	}
	
	public int efectoSegundo (Jugador jugador) {
		return  (int) ((jugador.getCapital()) % (jugador.getResultadoDados().getSuma()));
	}
	
	public int efectoTercero (Jugador jugador) {
		return -jugador.cantidadPropiedad();
	}

}
