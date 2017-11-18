package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorPropiedades {
	private ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
	
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
}
