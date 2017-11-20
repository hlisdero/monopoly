package fiuba.algo3.tp2.modelo;

public class Propiedad extends Casilla {
	protected double precio;
	protected double precioAlquiler;
	private double precioConstruirCasa;
	private double precioConstruirHotel;
	private double precioAlquilerUnaCasa;
	private double precioAlquilerDosCasas;
	private double precioAlquilerHotel;
	protected Jugador propietario;
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa, double precioAlquilerDosCasas, double precioAlquilerHotel) {
		this.precio = precio;
		this.precioAlquiler = precioAlquiler;
		this.precioConstruirCasa = precioConstruirCasa;
		this.precioConstruirHotel = precioConstruirHotel;
		this.precioAlquilerUnaCasa = precioAlquilerUnaCasa;
		this.precioAlquilerDosCasas = precioAlquilerDosCasas;
		this.precioAlquilerHotel = precioAlquilerHotel;
	}
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioAlquilerUnaCasa) {
		
		this.precio = precio;
		this.precioAlquiler = precioAlquiler;
		this.precioConstruirCasa = precioConstruirCasa;
		this.precioAlquilerUnaCasa = precioAlquilerUnaCasa;
	}
	
	public Propiedad(double precio, double precioAlquiler) {
		this.precio = precio;
		this.precioAlquiler = precioAlquiler;
	}
	
	public double getPrecioConstruirCasa() {
		return precioConstruirCasa;
	}

	public double getPrecioConstruirHotel() {
		return precioConstruirHotel;
	}

	public double getPrecioAlquilerUnaCasa() {
		return precioAlquilerUnaCasa;
	}

	public double getPrecioAlquilerDosCasas() {
		return precioAlquilerDosCasas;
	}

	public double getPrecioAlquilerHotel() {
		return precioAlquilerHotel;
	}
	
	public double getPrecioAlquiler(){
		return this.precioAlquiler;
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
		else if (!noTienePropietario() && jugador.getCapital() >= this.precioAlquiler) {
			jugador.restarDinero(precioAlquiler);
		}
	}
}
