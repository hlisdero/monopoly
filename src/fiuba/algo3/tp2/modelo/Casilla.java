package fiuba.algo3.tp2.modelo;

class Casilla {
	
	private int numeroCasilla;
	
	public Casilla()
	{
		this.numeroCasilla = 0;
	}
	
	
	public Casilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}
	
	public int siguiente(int posiciones) {
		return (numeroCasilla + posiciones) % 20;
	}
}
