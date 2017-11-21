package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.HashMap;

public class GestorPropiedades {
	private ArrayList<Inmueble> propiedades = new ArrayList<Inmueble>();
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
	
	public void construirHotel(Propiedad prop) throws CasasInsuficienteException {
		if (!cantidadDeHotelesPorPropiedad.containsKey(prop) && sePuedeConstruirHotel(prop)) {
			cantidadDeCasasPorPropiedad.put(prop, 0);
			cantidadDeHotelesPorPropiedad.put(prop, 1);
		}
		else throw new CasasInsuficienteException();
	}
	
	public boolean sePuedeConstruirHotel(Propiedad prop) {
		if (cantidadDeCasasPorPropiedad.get(prop) == 2)
			return true;
		else return false;
	}
	
	public void agregarPropiedad(Inmueble inmueble) {
		propiedades.add(inmueble);
	}
	
	public void quitarPropiedad(Inmueble prop) {
		propiedades.remove(prop);
	}
	
	
	public int getCantidadPropiedades() {
		return propiedades.size();
	}
	
	public int getCantidadCasas(Casilla prop) {
		if(!cantidadDeCasasPorPropiedad.containsKey(prop))
			return 0;
		else return cantidadDeCasasPorPropiedad.get(prop);
	}
	
	public boolean getCantidadHotel(Casilla prop) {
		if(!cantidadDeHotelesPorPropiedad.containsKey(prop))
			return false;
		else return true;
	}

	public boolean contiene(Empresa empresa) {
		return propiedades.contains(empresa);
	}
}
