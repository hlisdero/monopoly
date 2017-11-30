package fiuba.algo3.tp2.modelo;

public class Provincia extends Propiedad {
	private Alquiler alquiler;
	private Provincia provinciaHermana;
	
	public Provincia(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa,
			double precioAlquilerDosCasas, double precioAlquilerHotel, String nombre) {
		super(precio);
		alquiler = new Alquiler(precioAlquilerTerreno);
		alquiler.agregarMejora(precioAlquilerUnaCasa, precioConstruirCasa);
		alquiler.agregarMejora(precioAlquilerDosCasas, precioConstruirCasa);
		alquiler.agregarMejora(precioAlquilerHotel, precioConstruirHotel);
		alquiler.setCantidadCasasMaxima(2);
		setNombreCasilla(nombre);
	}
	
	public Provincia(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioAlquilerUnaCasa, String nombre) {
		super(precio);
		alquiler = new Alquiler(precioAlquilerTerreno, 0);
		alquiler.agregarMejora(precioAlquilerUnaCasa, precioConstruirCasa);
		alquiler.setCantidadCasasMaxima(1);
		setNombreCasilla(nombre);
	}
	
	public void setProvinciaHermana(Provincia provinciaHermana) {
		this.provinciaHermana = provinciaHermana;
	}

	public boolean existeProvinciaHermana() {
		return provinciaHermana != null;
	}
	
	public boolean provinciaHermanaMismoPropietario() {
		return this.getPropietario() == provinciaHermana.getPropietario();
	}
	
	public boolean hayCantidadCasasMaxima() {
		return alquiler.hayCantidadCasasMaxima();
	}
	
	public boolean sePuedeConstruirHotel() {
		if (!existeProvinciaHermana()) {
			return hayCantidadCasasMaxima();
		}
		return hayCantidadCasasMaxima() && provinciaHermana.hayCantidadCasasMaxima() && provinciaHermanaMismoPropietario();	
	}

	public int getCantidadCasas() {
		return alquiler.getCantidadCasas();
	}
	
	public boolean tieneHotel() {
		return alquiler.tieneHotel();
	}
	
	public void construirCasa() throws ConstruirCasaInvalidoException {
		alquiler.construirCasa();
		this.getPropietario().restarDinero(alquiler.getPrecioConstruccion());
	}
	
	public void construirHotel() throws ConstruirHotelInvalidoException {
		alquiler.construirHotel();
		this.getPropietario().restarDinero(alquiler.getPrecioConstruccion());
	}
	
	@Override
	public double getPrecioVenta() {
		return super.getPrecioVenta() + alquiler.getPrecioVentaConstruccion();
	}
	
	@Override
	public void vender(Jugador jugador) {
		if (getPropietario() == jugador) {
			this.setPropietario(null);
			jugador.agregarDinero(getPrecioVenta());
			alquiler.resetearMejoras();
		}
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (debeCobrar(jugador)) {
			jugador.restarDinero(alquiler.getPrecioAlquiler());
			this.getPropietario().agregarDinero(alquiler.getPrecioAlquiler());
		}
	}
}
