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
		
		list.add(new CasillaVista(1168,734,132,65,casillas.get(0)));
		list.add(new CasillaVista(1035,734,133,65,casillas.get(1)));
		list.add(new CasillaVista(901,734,133,65,casillas.get(2)));
		list.add(new CasillaVista(767,734,133,65,  casillas.get(3)));
		list.add(new CasillaVista(633,734,133,65 ,casillas.get(4)));
		list.add(new CasillaVista(500,734,133,65,casillas.get(5)));
		
		list.add(new CasillaVista(500,667,133,67,casillas.get(6)));
		list.add(new CasillaVista(500,600,133,67,casillas.get(7)));
		list.add(new CasillaVista(500,533,133,67,casillas.get(8)));
		list.add(new CasillaVista(500,466,133,67, casillas.get(9)));
		
		list.add(new CasillaVista(500,399,133,67, casillas.get(10)));
		list.add(new CasillaVista(633,399,133,67,casillas.get(11)));
		list.add(new CasillaVista(767,399,133,67 ,casillas.get(12)));
		list.add(new CasillaVista(901,399,133,67,casillas.get(13)));
		list.add(new CasillaVista(1035,399,133,67 ,casillas.get(14)));
		list.add(new CasillaVista(1168,399,132,67, casillas.get(15)));
		
		list.add(new CasillaVista(1168,466,132,67,casillas.get(16)));
		list.add(new CasillaVista(1168,533,132,67,casillas.get(17)));
		list.add(new CasillaVista(1168,600,132,67,casillas.get(18)));
		list.add(new CasillaVista(1168,667,132,67,casillas.get(19)));
		
		
		
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
	
	public void crearCasaVista(double posX, double posY){
		CasaVista casa = new CasaVista(posX, posY);
		CasaVista casa2 = new CasaVista(posX+30, posY);
		this.getChildren().addAll(casa, casa2);
		
	}

	public ArrayList<CasillaVista> getList() {
		return list;
	}

	public AlgoPoly getAlgo() {
		return algo;
	}
	
	

}
