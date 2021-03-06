package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorPropiedades {
	private ArrayList<Propiedad> propiedades = new ArrayList<Propiedad>();
	private Jugador propietario;

	public GestorPropiedades(Jugador propietario) {
		this.propietario = propietario;
	}
	
	public void comprar(Propiedad propiedad) {	
		propiedad.comprar(propietario);
		propiedades.add(propiedad);
	}
	
	public void vender(Propiedad propiedad) {
		propiedades.remove(propiedad);
		propiedad.vender(propietario);
	}
		
	public int getCantidadPropiedades() {
		return propiedades.size();
	}
	
	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public boolean esPropietario(Propiedad propiedad) {
		return propiedades.contains(propiedad);
	}
}
