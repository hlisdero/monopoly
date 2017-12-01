package fiuba.algo3.tp2.modelo;

public class Casilla {
	private String nombreCasilla;
	
	public void aplicarEfecto(Jugador jugador) {}
	
	public void setNombreCasilla(String nombreCasilla) {
		this.nombreCasilla = nombreCasilla;
	}
	
	public String getNombreCasilla() {
		return nombreCasilla;
	}
	
	public boolean sePuedeComprar() {
		return false;
	}
}
