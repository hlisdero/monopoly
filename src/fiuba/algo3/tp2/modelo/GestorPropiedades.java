package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorPropiedades {
	private ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();

	public void agregarPropiedad(Propiedad propiedad) {
		propiedades.add(propiedad);
	}
	
	public void quitarPropiedad(Propiedad propiedad) {
		propiedades.remove(propiedad);
	}
	
	public int getCantidadPropiedades() {
		return propiedades.size();
	}
	
	public boolean contiene(Empresa empresa) {
		return propiedades.contains(empresa);
	}
}
