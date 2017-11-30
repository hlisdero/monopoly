package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.AlgoPoly;
import fiuba.algo3.tp2.modelo.Casilla;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;



public class TerrenoVista extends Parent{
	
	public ArrayList<CasillaVista> list = new ArrayList<CasillaVista>();
	private AlgoPoly algo = new AlgoPoly();
	
	public TerrenoVista()
	{
		this.dibujarTereno();
	}
	
	
	public void dibujarTereno(){
		
		ArrayList<Casilla> casillas = algo.getCasillas();
		
		list.add(new CasillaVista(1168,734,132,65,casillas.get(0),0));
		list.add(new CasillaVista(1035,734,133,65,casillas.get(1),1));
		list.add(new CasillaVista(901,734,133,65,casillas.get(2),2));
		list.add(new CasillaVista(767,734,133,65,  casillas.get(3),3));
		list.add(new CasillaVista(633,734,133,65 ,casillas.get(4),4));
		list.add(new CasillaVista(500,734,133,65,casillas.get(5),5));
		
		list.add(new CasillaVista(500,667,133,67,casillas.get(6),6));
		list.add(new CasillaVista(500,600,133,67,casillas.get(7),7));
		list.add(new CasillaVista(500,533,133,67,casillas.get(8),8));
		list.add(new CasillaVista(500,466,133,67, casillas.get(9),9));
		
		list.add(new CasillaVista(500,399,133,67, casillas.get(10),10));
		list.add(new CasillaVista(633,399,133,67,casillas.get(11),11));
		list.add(new CasillaVista(767,399,133,67 ,casillas.get(12),12));
		list.add(new CasillaVista(901,399,133,67,casillas.get(13),13));
		list.add(new CasillaVista(1035,399,133,67 ,casillas.get(14),14));
		list.add(new CasillaVista(1168,399,132,67, casillas.get(15),15));
		
		list.add(new CasillaVista(1168,466,132,67,casillas.get(16),16));
		list.add(new CasillaVista(1168,533,132,67,casillas.get(17),17));
		list.add(new CasillaVista(1168,600,132,67,casillas.get(18),18));
		list.add(new CasillaVista(1168,667,132,67,casillas.get(19),19));
		
		
		
		ImageView image = new ImageView ("File:images/tablero.png ");
		image.setLayoutX(500);
		image.setLayoutY(400);
		image.setFitWidth(800);
		image.setFitHeight(400);
		
		this.getChildren().add(image);
		
		for(CasillaVista casilla: list){
			this.getChildren().addAll(casilla);
		}
		
		
	}
	
	public void crearCasaVista(double posX, double posY, JugadorVista jugadorVista, CasillaVista casilla){
		CasaVista casa = new CasaVista(posX, posY,jugadorVista);
		casilla.agregarPropiedad(casa);
		this.getChildren().addAll(casa);
	}
	
	public void crearHotelVista(double posX, double posY, CasillaVista casilla){
		HotelVista hotel = new HotelVista(posX, posY);
		casilla.agregarPropiedad(hotel);
		this.getChildren().addAll(hotel);
	}

	public ArrayList<CasillaVista> getCasillasVista() {
		return list;
	}

	public AlgoPoly getControlador() {
		return algo;
	}


	public void venderCasa(CasillaVista casilla) {
		for  (Parent elemento: casilla.removePropiedades()) {
			this.getChildren().remove(elemento);
		}			
	}


	public Casilla getCasillaJugadorVista(JugadorVista jugador) {
		return list.get(jugador.getNumeroCasilla()).getValorCasilla();
	}


	public CasillaVista getCasillaVista(int posicionNueva) {
		return list.get(posicionNueva);
	}
	
	

}
