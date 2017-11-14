package fiuba.algo3.tp2.modelo;

public class Casilla {
		
	public void aplicarEfecto(Jugador jugador) {
	}
	
	public int getIndiceCasillaSiguiente(int posicionCasillaActual, ResultadoDados dados) {
		return posicionCasillaActual + dados.getSuma();
	}

}
