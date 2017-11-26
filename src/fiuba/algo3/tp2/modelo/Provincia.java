package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Provincia extends Propiedad {
	private ArrayList<MejoraProvincia> estadosPosibles = new ArrayList<MejoraProvincia>();
	private MejoraProvincia estadoActual;
	
	public Provincia(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa, double precioAlquilerDosCasas, double precioAlquilerHotel, String nombre) {
		super(precio);
		MejoraProvincia terreno = new MejoraProvincia(precioAlquilerTerreno);
		MejoraProvincia unaCasa = new MejoraProvincia(precioAlquilerUnaCasa, precioConstruirCasa);
		MejoraProvincia dosCasas = new MejoraProvincia(precioAlquilerDosCasas, precioConstruirCasa);
		MejoraProvincia hotel = new MejoraProvincia(precioAlquilerHotel, precioConstruirHotel);
		estadosPosibles.add(terreno);
		estadosPosibles.add(unaCasa);
		estadosPosibles.add(dosCasas);
		estadosPosibles.add(hotel);
		estadoActual = terreno;
		this.nombreCasilla = nombre;
	}
	
	public Provincia(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioAlquilerUnaCasa, String nombre) {
		super(precio);
		MejoraProvincia terreno = new MejoraProvincia(precioAlquilerTerreno);
		MejoraProvincia unaCasa = new MejoraProvincia(precioAlquilerUnaCasa, precioConstruirCasa);
		estadosPosibles.add(terreno);
		estadosPosibles.add(unaCasa);
		estadoActual = terreno;
	}

	public boolean sePuedeConstruirHotel() {
		return (estadosPosibles.size() == 4);
	}

	public int getCantidadCasas() {
		return estadosPosibles.indexOf(estadoActual);
	}
	
	public boolean tieneHotel(Casilla prop) {
		return (estadoActual == estadosPosibles.get(3));
	}
	
	public void construirCasa() throws ConstruirCasaInvalidoException {
		if (estadoActual == estadosPosibles.get(0)) {
			estadoActual = estadosPosibles.get(1);
		} else if (estadoActual == estadosPosibles.get(1)) {
			estadoActual = estadosPosibles.get(2);
		} else {
			throw new ConstruirCasaInvalidoException();
		}
		this.getPropietario().restarDinero(estadoActual.getPrecioConstruccion());
	}
	
	public void construirHotel(Jugador jugador) throws ConstruirHotelInvalidoException {
		if (estadoActual == estadosPosibles.get(2)) {
			estadoActual = estadosPosibles.get(3);
		} else {
			throw new ConstruirHotelInvalidoException();
		}
		jugador.restarDinero(estadoActual.getPrecioConstruccion());
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (tienePropietario() && this.getPropietario() != jugador) {
			jugador.restarDinero(estadoActual.getPrecioAlquiler());
			this.getPropietario().agregarDinero(estadoActual.getPrecioAlquiler());
		}
	}
}
