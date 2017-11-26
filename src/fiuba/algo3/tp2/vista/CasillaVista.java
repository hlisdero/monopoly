package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Casilla;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class CasillaVista extends Parent{
	
	private double posX;
	private double posY;
	private double sizeX;
	private double sizeY;
	private String valorCasilla;
	
	private Rectangle casilla;
	
	
	public CasillaVista(double positionX, double positionY, double sizeX, double sizeY, Casilla valorCasilla){
		
		this.posX = positionX;
		this.posY = positionY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.valorCasilla = valorCasilla.nombreCasilla();
		
		casilla = new Rectangle();
		casilla.setWidth(this.sizeX);
		casilla.setHeight(this.sizeY);
		casilla.setX(this.posX);
		casilla.setY(this.posY);

		casilla.setFill(Color.TRANSPARENT);
	    casilla.setStroke(Color.TRANSPARENT);
		
		
	    this.getChildren().add(casilla);
	}
	public double  getPosX() {
		return this.posX;
		
	}
	public double  getPosY() {
		return this.posY;
		
	}
	public double  getWidthX() {
		return this.sizeX;
		
	}
	public double  getHeightY() {
		return this.sizeY;
		
	}
	public String getValorCasilla() {
		return valorCasilla;
	}
	
	

}
