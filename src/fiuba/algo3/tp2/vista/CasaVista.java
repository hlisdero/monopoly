package fiuba.algo3.tp2.vista;


import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class CasaVista extends Parent{
	
	private double posX;
	private double posY;
	private double sizeX;
	private double sizeY;
	
	private static double translacion;

	 
	
	public CasaVista(double positionX, double positionY, JugadorVista jugadorVista){
		translacion += 10;
		this.posX = positionX + translacion;
		this.posY = positionY;
		this.sizeX = 20;
		this.sizeY = 20;
		ImageView casa = new ImageView("File:images/casa"+(jugadorVista.getNumeroJugador())+".png");
		casa.setFitWidth(this.sizeX);
		casa.setFitHeight(this.sizeY);
		casa.setX(this.posX);
		casa.setY(this.posY);

		this.getChildren().add(casa);
	}

}
