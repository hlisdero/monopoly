package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.Casilla;
import fiuba.algo3.tp2.modelo.Propiedad;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;



public class CasillaVista extends Parent{
	
	private  ArrayList<Parent> listaPropiedades = new ArrayList<Parent>() ;
	private double posX;
	private double posY;
	private double sizeX;
	private double sizeY;
	private Casilla valorCasilla;
	private String name;
	private Rectangle casilla;
	private Tooltip tp = new Tooltip();
	
	
	public CasillaVista(double positionX, double positionY, double sizeX, double sizeY, final Casilla valorCasilla, final int numeroCasilla){
		
		this.posX = positionX;
		this.posY = positionY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.valorCasilla = valorCasilla;
		this.name = valorCasilla.getNombreCasilla();
		
		casilla = new Rectangle();
		casilla.setWidth(this.sizeX);
		casilla.setHeight(this.sizeY);
		casilla.setX(this.posX);
		casilla.setY(this.posY);

		casilla.setFill(Color.TRANSPARENT);
	    casilla.setStroke(Color.TRANSPARENT);
		
	    
	    casilla.setOnMouseMoved(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	        			Tooltip.install(casilla, tp);
	        			try{
	        			tp.setText("Nombre casilla: "+name+
	        					"\nPrecio casilla: "+((Propiedad) valorCasilla).getPrecio()+
	        					"\nNumero casilla: "+numeroCasilla
	        					);
	        			 }  catch(ClassCastException e){
	        				 tp.setText("Nombre casilla: "+name+
	 	        					"\nNumero casilla: "+numeroCasilla);
	        			 }
	        			tp.show(casilla, event.getScreenX(), event.getScreenY());
	        }
	    });
	    
	  
	    casilla.setOnMouseExited(new EventHandler<MouseEvent>() {
	        @Override
	        public void handle(MouseEvent event) {
	        	 tp.hide();	
	        }
	    });
	   
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
	public Casilla getValorCasilla() {
		return valorCasilla;
	}
	
	public String getName(){
		return this.name;
	}
	public ArrayList<Parent> removePropiedades() {
		
		return this.listaPropiedades;
						
		
	}
	public void agregarPropiedad(Parent propiedad) {
		this.listaPropiedades.add(propiedad);

	}
	
	
	

}
