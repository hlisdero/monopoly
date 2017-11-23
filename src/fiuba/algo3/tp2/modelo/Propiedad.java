package fiuba.algo3.tp2.modelo;

public class Propiedad extends Inmueble {
	private double precioAlquiler;
	private double precioConstruirCasa;
	private double precioConstruirHotel;
	private double precioAlquilerUnaCasa;
	private double precioAlquilerDosCasas;
	private double precioAlquilerHotel;
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa, double precioAlquilerDosCasas, double precioAlquilerHotel) {
		super(precio);
		this.precioAlquiler = precioAlquiler;
		this.precioConstruirCasa = precioConstruirCasa;
		this.precioConstruirHotel = precioConstruirHotel;
		this.precioAlquilerUnaCasa = precioAlquilerUnaCasa;
		this.precioAlquilerDosCasas = precioAlquilerDosCasas;
		this.precioAlquilerHotel = precioAlquilerHotel;
	}
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioAlquilerUnaCasa) {
		super(precio);
		this.precioAlquiler = precioAlquiler;
		this.precioConstruirCasa = precioConstruirCasa;
		this.precioAlquilerUnaCasa = precioAlquilerUnaCasa;
	}
	
	public Propiedad(double precio, double precioAlquiler) {
		super(precio);
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
		
		if (noTienePropietario() && jugador.getCapital() >= this.getPrecio()) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(this.getPrecio());
		} 
		else if (tienePropietario()) {
			double precioACobrar;
			
			if (getPropietario().getGestorPropiedades().getCantidadCasas(jugador.getCasilla()) == 1) {
				precioACobrar = precioAlquilerUnaCasa;
			} else if (getPropietario().getGestorPropiedades().getCantidadCasas(jugador.getCasilla()) == 2) {
				precioACobrar = precioAlquilerDosCasas;
			} else if (getPropietario().getGestorPropiedades().getCantidadHotel(jugador.getCasilla())) {
				precioACobrar = precioAlquilerHotel;
			} else {
				precioACobrar = precioAlquiler;
			}
			jugador.restarDinero(precioACobrar);
			getPropietario().agregarDinero(precioACobrar);
		}
	}

}
