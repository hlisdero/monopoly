package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Casilla;
import javafx.scene.Parent;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class CasillaVista extends Parent{
	
	private double posX;
	private double posY;
	private double sizeX;
	private double sizeY;
	private Casilla valorCasilla;
	
	private Rectangle casilla;
	
	
	public CasillaVista(int positionX, int positionY, int sizeX, int sizeY, Color color, Casilla valorCasilla){
		
		this.posX = positionX;
		this.posY = positionY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.valorCasilla = valorCasilla;
		
		casilla = new Rectangle();
		casilla.setWidth(this.sizeX);
		casilla.setHeight(this.sizeY);
		casilla.setX(this.posX);
		casilla.setY(this.posY);

		casilla.setFill(color);
	    casilla.setStroke(Color.BLACK);
		
	    
	    this.getChildren().addAll(casilla);
	}

	public Casilla getValorCasilla() {
		return valorCasilla;
	}
	
	

}
