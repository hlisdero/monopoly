package fiuba.algo3.tp2.modelo;

class Policia extends Casilla {
	private int posicionCarcel;
	
	Policia(int posicionCarcel) {
		this.posicionCarcel = posicionCarcel;
	}
	
	@Override
	public int getIndiceCasillaSiguiente(int posicionCasillaActual, ResultadoDados dados) {
		return posicionCarcel;
	}

}
