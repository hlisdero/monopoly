package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorPropiedades {
	private ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
	private HashMap<Propiedad, Integer> cantidadDeCasasPorPropiedad = new HashMap<Propiedad, Integer>();
	private HashMap<Propiedad, Integer> cantidadDeHotelesPorPropiedad = new HashMap<Propiedad, Integer>();
	
	public void construirCasa(Propiedad prop) {
		if (!cantidadDeCasasPorPropiedad.containsKey(prop)) {
			cantidadDeCasasPorPropiedad.put(prop, 1);
		} else {
			int cantidadDeCasas = cantidadDeCasasPorPropiedad.get(prop);
			cantidadDeCasasPorPropiedad.put(prop, cantidadDeCasas + 1);
		}
	}
	
	public void construirHotel(Propiedad prop) {
		if (!cantidadDeHotelesPorPropiedad.containsKey(prop)) {
			cantidadDeHotelesPorPropiedad.put(prop, 1);
		}
	}
	
	public void agregarPropiedad(Propiedad prop) {
		propiedades.add(prop);
	}
	
	public void quitarPropiedad(Propiedad prop) {
		propiedades.remove(prop);
	}
	
	public double calcularRenta() {
		double renta = 0;
		for(int i = 0; i < propiedades.size(); i++){
			//propiedades.get(i).getPrecioRenta();
		}
		return renta;
	}
	
	public int getCantidadPropiedades() {
		return propiedades.size();
	}
	
	public int getCantidadCasas(Casilla prop) {
		return cantidadDeCasasPorPropiedad.get(prop);
	}
	
	public boolean getCantidadHotel(Casilla prop) {
		if (cantidadDeHotelesPorPropiedad.get(prop) == 1)
			return true;
		else return false;
	}
}
