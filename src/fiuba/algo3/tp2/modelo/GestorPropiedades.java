package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorPropiedades {
	private ArrayList<Inmueble> propiedades = new ArrayList<Inmueble>();

	public void agregarPropiedad(Inmueble inmueble) {
		propiedades.add(inmueble);
	}
	
	public void quitarPropiedad(Inmueble inmueble) {
		propiedades.remove(inmueble);
	}
	
	public int getCantidadPropiedades() {
		return propiedades.size();
	}
	
	public boolean contiene(Empresa empresa) {
		return propiedades.contains(empresa);
	}
}
