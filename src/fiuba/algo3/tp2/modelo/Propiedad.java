package fiuba.algo3.tp2.modelo;

public class Propiedad extends Inmueble {
	private static double precioSiHayConstrucciones;
	protected double precioAlquiler;
	private double precioConstruirCasa;
	private double precioConstruirHotel;
	private double precioAlquilerUnaCasa;
	private double precioAlquilerDosCasas;
	private double precioAlquilerHotel;
	
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
	
	public void construirCasa(Jugador jugador) {
		jugador.getGestorPropiedades().construirCasa(this);
		jugador.restarDinero(precioConstruirCasa);
	}
	
	public void construirHotel(Jugador jugador) throws CasasInsuficienteException {
		jugador.getGestorPropiedades().construirHotel(this);
		jugador.restarDinero(precioConstruirHotel);
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		
		if (noTienePropietario() && jugador.getCapital() >= precio) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(precio);
		}
		
		else if (!noTienePropietario()) {
			precioAlquilerJugadorTieneConstrucciones(jugador);
			jugador.restarDinero(precioSiHayConstrucciones);
			getPropietario().agregarDinero(precioSiHayConstrucciones);
		}
	}

	public void precioAlquilerJugadorTieneConstrucciones(Jugador jugador) {
		if (getPropietario().getGestorPropiedades().getCantidadCasas(jugador.getCasilla()) == 1){
			precioSiHayConstrucciones = precioAlquilerUnaCasa;
		}
		else if (getPropietario().getGestorPropiedades().getCantidadCasas(jugador.getCasilla()) == 2){
			precioSiHayConstrucciones = precioAlquilerDosCasas;
		}
		else if (getPropietario().getGestorPropiedades().getCantidadHotel(jugador.getCasilla())){
			precioSiHayConstrucciones = precioAlquilerHotel;
		}
		else precioSiHayConstrucciones = precioAlquiler;
	}
	
}
