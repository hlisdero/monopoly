package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import javafx.scene.Parent;

public class TurnoJugador extends Parent {
	private TerrenoVista tabla = new TerrenoVista();
	private ArrayList<JugadorVista> listaJugadores;
	private JugadorVista J1;
	private JugadorVista J2;
	private JugadorVista J3;
	private JugadorVista jugadorGenerico;
	
	public TurnoJugador(){
		J1 = new JugadorVista(tabla.getControlador().getJugador(), 0,1);
		J2 = new JugadorVista(tabla.getControlador().getJugador(), 0, 2);
		J3 = new JugadorVista(tabla.getControlador().getJugador(), 0, 3);
		
		listaJugadores = new ArrayList<JugadorVista>();
		
		listaJugadores.add(J1);
		listaJugadores.add(J2);
		listaJugadores.add(J3);
		
		J1.asignarPosicion(tabla.getCasillasVista().get(0).getPosX(), tabla.getCasillasVista().get(0).getPosY());
		J2.asignarPosicion(tabla.getCasillasVista().get(0).getPosX(), tabla.getCasillasVista().get(0).getPosY());
		J3.asignarPosicion(tabla.getCasillasVista().get(0).getPosX(), tabla.getCasillasVista().get(0).getPosY());
		
		jugadorGenerico= listaJugadores.get(0);
       	
		this.getChildren().addAll(J1,J2,J3);	
	}

	public JugadorVista getJugadorGenerico() {
		return jugadorGenerico;
	}

	public TerrenoVista getTabla() {
		return tabla;
	}

	public void setJugadorGenerico(JugadorVista jugadorGenerico) {
		this.jugadorGenerico = jugadorGenerico;
	}

	public ArrayList<JugadorVista> getListaJugadores() {
		return listaJugadores;
	}

	public JugadorVista getJ1() {
		return J1;
	}

	public JugadorVista getJ2() {
		return J2;
	}

	public JugadorVista getJ3() {
		return J3;
	}

}