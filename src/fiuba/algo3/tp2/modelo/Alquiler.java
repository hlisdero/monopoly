package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Alquiler {
	private ArrayList<MejoraProvincia> mejoras = new ArrayList<MejoraProvincia>();
	private int estadoMejora = 0;
	private int cantidadCasasMaxima;
	
	public Alquiler(double precioAlquiler, double precioConstruccion) {
		agregarMejora(precioAlquiler, precioConstruccion);
	}
	
	public Alquiler(double precioAlquiler) {
		this(precioAlquiler, 0);
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
		estadoMejora = 0;
	}
		
	public double getPrecioAlquiler() {
		return mejoras.get(estadoMejora).getPrecioAlquiler();
	}
	
	public double getPrecioConstruccion() {
		return mejoras.get(estadoMejora).getPrecioConstruccion();
	}
	
	public int getCantidadCasas() {
		return (estadoMejora <= cantidadCasasMaxima? estadoMejora : 0);
	}
	
	public boolean tieneHotel() {
		return (estadoMejora > cantidadCasasMaxima);
	}
	
	public void construirCasa() throws ConstruirCasaInvalidoException {
		if (estadoMejora >= cantidadCasasMaxima) {
			throw new ConstruirCasaInvalidoException();
		}
		estadoMejora++;
	}
	
	public void construirHotel() throws ConstruirHotelInvalidoException {
		if (!hayCantidadCasasMaxima()) {
			throw new ConstruirHotelInvalidoException();
		}
		estadoMejora++;
	}
}
