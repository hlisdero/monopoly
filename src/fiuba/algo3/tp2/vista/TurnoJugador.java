package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import javafx.scene.Parent;

public class TurnoJugador extends Parent {
	

	
	
	TablaDeJuego tabla = new TablaDeJuego();
	private ArrayList<JugadorVista> listaJugadores;
	JugadorVista J1;
	JugadorVista J2;
	JugadorVista J3;
	
	
	public TurnoJugador(){

		 J1 = new JugadorVista(tabla.getAlgo().getGestorTurnos().proximoJugador(), tabla.getAlgo().getGestorMovimiento().getTablero().getCasillas().indexOf(tabla.getAlgo().getGestorMovimiento().getTablero().getCasillaInicial()));
		 J2 = new JugadorVista(tabla.getAlgo().getGestorTurnos().proximoJugador(), tabla.getAlgo().getGestorMovimiento().getTablero().getCasillas().indexOf(tabla.getAlgo().getGestorMovimiento().getTablero().getCasillaInicial()));
		 J3 = new JugadorVista(tabla.getAlgo().getGestorTurnos().proximoJugador(), tabla.getAlgo().getGestorMovimiento().getTablero().getCasillas().indexOf(tabla.getAlgo().getGestorMovimiento().getTablero().getCasillaInicial()));
		
		listaJugadores = new ArrayList<JugadorVista>();
		
		listaJugadores.add(J1);
		listaJugadores.add(J2);
		listaJugadores.add(J3);
		
		J1.asignarPosicion(tabla.getList().get(0).getPosX(), tabla.getList().get(0).getPosY());
		J2.asignarPosicion(tabla.getList().get(0).getPosX(), tabla.getList().get(0).getPosY());
		J3.asignarPosicion(tabla.getList().get(0).getPosX(), tabla.getList().get(0).getPosY());
       	
		this.getChildren().addAll(J1,J2,J3);
		
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