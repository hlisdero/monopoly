package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Propiedad extends Inmueble {
	private ArrayList<MejoraPropiedad> estadosPosibles = new ArrayList<MejoraPropiedad>();
	private MejoraPropiedad estadoActual;
	
	public Propiedad(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioConstruirHotel, double precioAlquilerUnaCasa, double precioAlquilerDosCasas, double precioAlquilerHotel) {
		super(precio);
		MejoraPropiedad terreno = new MejoraPropiedad(precioAlquilerTerreno);
		MejoraPropiedad unaCasa = new MejoraPropiedad(precioAlquilerUnaCasa, precioConstruirCasa);
		MejoraPropiedad dosCasas = new MejoraPropiedad(precioAlquilerDosCasas, precioConstruirCasa);
		MejoraPropiedad hotel = new MejoraPropiedad(precioAlquilerHotel, precioConstruirHotel);
		estadosPosibles.add(terreno);
		estadosPosibles.add(unaCasa);
		estadosPosibles.add(dosCasas);
		estadosPosibles.add(hotel);
		estadoActual = terreno;
	}
	
	public Propiedad(double precio, double precioAlquilerTerreno, double precioConstruirCasa, double precioAlquilerUnaCasa) {
		super(precio);
		MejoraPropiedad terreno = new MejoraPropiedad(precioAlquilerTerreno);
		MejoraPropiedad unaCasa = new MejoraPropiedad(precioAlquilerUnaCasa, precioConstruirCasa);
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
	
	public void construirCasa(Jugador jugador) throws ConstruirCasaInvalidoException {
		if (estadoActual == estadosPosibles.get(0)) {
			estadoActual = estadosPosibles.get(1);
		} else if (estadoActual == estadosPosibles.get(1)) {
			estadoActual = estadosPosibles.get(2);
		} else {
			throw new ConstruirCasaInvalidoException();
		}
		jugador.restarDinero(estadoActual.getPrecioConstruccion());
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
		if (noTienePropietario() && jugador.getCapital() >= this.getPrecio()) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(this.getPrecio());
		} else if (tienePropietario()) {
			jugador.restarDinero(estadoActual.getPrecioAlquiler());
			getPropietario().agregarDinero(estadoActual.getPrecioAlquiler());
		}
	}
}
