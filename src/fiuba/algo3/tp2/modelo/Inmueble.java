package fiuba.algo3.tp2.modelo;

public class Inmueble extends Casilla{
	protected double precio;
	protected Jugador propietario;
	
	public double getPrecio() {
		return precio;
	}
	
	public Jugador getPropietario() {
		return this.propietario;
	}
	
	
	public boolean noTienePropietario() {
		return (propietario == null);
	}
}
