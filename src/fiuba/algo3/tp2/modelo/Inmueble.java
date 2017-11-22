package fiuba.algo3.tp2.modelo;

public class Inmueble extends Casilla{
	protected double precio;
	protected double precioAlquiler;
	protected Jugador propietario;
	protected double precioDeVenta;
	
	public Inmueble(){
		this.precioDeVenta = this.precio - (this.precio*0.15);
	}
	
	public Inmueble(double precio, double precioAlquiler){
		this.precio = precio;
		this.precioAlquiler = precioAlquiler;
	}
	

	public double getPrecioDeVenta() {
		return precioDeVenta;
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
	
	public void jugadorVendePropiedad(Jugador jugador) {
		
		jugador.getGestorPropiedades().quitarPropiedad(this);
		jugador.agregarDinero(precioDeVenta);
		setPropietario(null);
	}

}
