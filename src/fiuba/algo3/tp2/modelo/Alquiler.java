package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Alquiler {
	private ArrayList<MejoraProvincia> mejoras = new ArrayList<MejoraProvincia>();
	private int cantidadCasasMaxima;
	private int estado = 0;
	
	public Alquiler(double precioAlquiler, double precioConstruccion) {
		agregarMejora(precioAlquiler, precioConstruccion);
	}
	
	public Alquiler(double precioAlquiler) {
		this(precioAlquiler, 0);
	}

	private void mejorar() {
		estado++;
	}
	
	public void setCantidadCasasMaxima(int cantidadCasasMaxima) {
		this.cantidadCasasMaxima = cantidadCasasMaxima;
	}
	
	public boolean hayCantidadCasasMaxima() {
		return getCantidadCasas() == cantidadCasasMaxima;
	}
	
	public void agregarMejora(double precioAlquiler, double precioConstruccion) {
		mejoras.add(new MejoraProvincia(precioAlquiler, precioConstruccion));
	}
	
	public void resetearMejoras() {
		estado = 0;
	}
		
	public double getPrecioAlquiler() {
		return mejoras.get(estado).getPrecioAlquiler();
	}
	
	public double getPrecioConstruccion() {
		return mejoras.get(estado).getPrecioConstruccion();
	}
	
	public int getCantidadCasas() {
		return (estado <= cantidadCasasMaxima? estado : 0);
	}
	
	public boolean tieneHotel() {
		return (estado > cantidadCasasMaxima);
	}
	
	public void construirCasa() throws ConstruirCasaInvalidoException {
		if (estado >= cantidadCasasMaxima) {
			throw new ConstruirCasaInvalidoException();
		}
		mejorar();
	}
	
	public void construirHotel() throws ConstruirHotelInvalidoException {
		if (!hayCantidadCasasMaxima()) {
			throw new ConstruirHotelInvalidoException();
		}
		mejorar();
	}
}
