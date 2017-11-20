package fiuba.algo3.tp2.modelo;

public class Propiedad extends Casilla {
	protected double precio;
	protected double precioDeAlquiler;
	protected Jugador propietario;
	
	public Propiedad(double precio, double precioDeAlquiler) {
		this.precio = precio;
		this.precioDeAlquiler = precioDeAlquiler;
	}
	
	public double getPrecioDeAlquiler(){
		return this.precioDeAlquiler;
	}

	public double getPrecio() {
		return precio;
	}

	public Jugador getPropietario() {
		return this.propietario;
	}

	public boolean noTienePropietario() {
		return (propietario == null);
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (noTienePropietario() && jugador.getCapital() >= precio) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(precio);
		}
		else if (!noTienePropietario() && jugador.getCapital() >= this.precioDeAlquiler) {
			jugador.restarDinero(precioDeAlquiler);
		}
	}
}
