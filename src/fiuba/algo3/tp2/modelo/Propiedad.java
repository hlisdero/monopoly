package fiuba.algo3.tp2.modelo;

public class Propiedad extends Inmueble {
	private double precioAlquiler;
	private MejoraPropiedad unaCasa;
	private MejoraPropiedad dosCasas;
	private MejoraPropiedad hotel;
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa, double precioAlquilerDosCasas, double precioAlquilerHotel) {
		super(precio);
		this.precioAlquiler = precioAlquiler;
		unaCasa = new MejoraPropiedad(precioAlquilerUnaCasa, precioConstruirCasa);
		dosCasas = new MejoraPropiedad(precioAlquilerDosCasas, precioConstruirCasa);
		hotel = new MejoraPropiedad(precioAlquilerHotel, precioConstruirHotel);
	}
	
	public Propiedad(double precio, double precioAlquiler, double precioConstruirCasa, double precioAlquilerUnaCasa) {
		super(precio);
		this.precioAlquiler = precioAlquiler;
		unaCasa = new MejoraPropiedad(precioAlquilerUnaCasa, precioConstruirCasa);
	}
	
	public Propiedad(double precio, double precioAlquiler) {
		super(precio);
	}
	
	public void construirCasa(Jugador jugador) {
		jugador.getGestorPropiedades().construirCasa(this);
		jugador.restarDinero(unaCasa.getPrecioConstruccion());
	}
	
	public void construirHotel(Jugador jugador) throws CasasInsuficienteException {
		jugador.getGestorPropiedades().construirHotel(this);
		jugador.restarDinero(hotel.getPrecioConstruccion());
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
				precioACobrar = unaCasa.getPrecioAlquiler();
			} else if (getPropietario().getGestorPropiedades().getCantidadCasas(jugador.getCasilla()) == 2) {
				precioACobrar = dosCasas.getPrecioAlquiler();
			} else if (getPropietario().getGestorPropiedades().getCantidadHotel(jugador.getCasilla())) {
				precioACobrar = hotel.getPrecioAlquiler();
			} else {
				precioACobrar = precioAlquiler;
			}
			jugador.restarDinero(precioACobrar);
			getPropietario().agregarDinero(precioACobrar);
		}
	}
}
