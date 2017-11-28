package fiuba.algo3.tp2.vista;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;

public class HotelVista extends Parent{
	
	private double posX;
	private double posY;
	private double sizeX;
	private double sizeY;
	
	

	private ImageView casa = new ImageView("File:images/hotel.png");
	
	public HotelVista(double positionX, double positionY){
		
		this.posX = positionX;
		this.posY = positionY;
		this.sizeX = 20;
		this.sizeY = 20;
	
		casa.setFitWidth(this.sizeX);
		casa.setFitHeight(this.sizeY);
		casa.setX(this.posX);
		casa.setY(this.posY);

		this.getChildren().add(casa);
	}
		
}
