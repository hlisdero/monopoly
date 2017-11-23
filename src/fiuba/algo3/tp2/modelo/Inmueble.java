package fiuba.algo3.tp2.modelo;

public class Inmueble extends Casilla {
	private static final double COMISION_VENTA = 0.15;
	private double precio;
	protected Jugador propietario;
	
	public Inmueble(double precio){
		this.precio = precio;
	}

	public double getPrecioDeVenta() {
		return precio * (1 - COMISION_VENTA);
	}

	public double getPrecio() {
		return precio;
	}
	
	public Jugador getPropietario() {
		return this.propietario;
	}
	
	
	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public boolean noTienePropietario() {
		return (propietario == null);
	}
	
	public boolean tienePropietario() {
		return !noTienePropietario();
	}
	
	public void jugadorVendePropiedad(Jugador jugador) {	
		jugador.getGestorPropiedades().quitarPropiedad(this);
		jugador.agregarDinero(getPrecioDeVenta());
		setPropietario(null);
	}

}
