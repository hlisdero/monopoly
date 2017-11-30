package fiuba.algo3.tp2.modelo;

public class Propiedad extends Casilla {
	private static final double COMISION_VENTA = 0.15;
	private double precio;
	private Jugador propietario;
	
	public Propiedad(double precio) {
		this.precio = precio;
	}

	public double getPrecioVenta() {
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
	
	public boolean tienePropietario() {
		return (propietario != null);
	}
	
	public boolean debeCobrar(Jugador jugador) {
		return (tienePropietario() && jugador != propietario);
	}
	
	public void comprar(Jugador jugador) {
		propietario = jugador;
		jugador.restarDinero(getPrecio());
	}
	
	public void vender(Jugador jugador) {
		if (getPropietario() == jugador) {
			this.setPropietario(null);
			jugador.agregarDinero(getPrecioVenta());
		}
	}
}
