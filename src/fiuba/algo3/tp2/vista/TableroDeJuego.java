package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.AlgoPoly;
import javafx.scene.Parent;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TableroDeJuego extends Parent{
	
	private AlgoPoly algo = new AlgoPoly();
	public ArrayList<CasillaVista> list = new ArrayList<CasillaVista>();
	
	
	public TableroDeJuego(){

		list.add(new CasillaVista(600,400,100,60, Color.WHITE,algo.getGestorMovimiento().getTablero().getCasillas().get(0)));
		list.add(new CasillaVista(500,400,100,60, Color.GREEN,algo.getGestorMovimiento().getTablero().getCasillas().get(1)));
		list.add(new CasillaVista(400,400,100,60, Color.LIGHTBLUE,algo.getGestorMovimiento().getTablero().getCasillas().get(2)));
		list.add(new CasillaVista(300,400,100,60, Color.YELLOW, algo.getGestorMovimiento().getTablero().getCasillas().get(3)));
		list.add(new CasillaVista(200,400,100,60, Color.LIGHTBLUE,algo.getGestorMovimiento().getTablero().getCasillas().get(4)));
		list.add(new CasillaVista(100,400,100,60, Color.GREY,algo.getGestorMovimiento().getTablero().getCasillas().get(5)));
		
		list.add(new CasillaVista(100,340,100,60, Color.ORANGE,algo.getGestorMovimiento().getTablero().getCasillas().get(6)));
		list.add(new CasillaVista(100,280,100,60, Color.GREEN,algo.getGestorMovimiento().getTablero().getCasillas().get(7)));
		list.add(new CasillaVista(100,220,100,60, Color.YELLOW,algo.getGestorMovimiento().getTablero().getCasillas().get(8)));
		list.add(new CasillaVista(100,160,100,60, Color.ORANGE, algo.getGestorMovimiento().getTablero().getCasillas().get(9)));
		
		list.add(new CasillaVista(100,100,100,60, Color.GREEN, algo.getGestorMovimiento().getTablero().getCasillas().get(10)));
		list.add(new CasillaVista(200,100,100,60, Color.PINK,algo.getGestorMovimiento().getTablero().getCasillas().get(11)));
		list.add(new CasillaVista(300,100,100,60, Color.YELLOW,algo.getGestorMovimiento().getTablero().getCasillas().get(12)));
		list.add(new CasillaVista(400,100,100,60, Color.CORNFLOWERBLUE,algo.getGestorMovimiento().getTablero().getCasillas().get(13)));
		list.add(new CasillaVista(500,100,100,60, Color.CORNFLOWERBLUE,algo.getGestorMovimiento().getTablero().getCasillas().get(14)));
		list.add(new CasillaVista(600,100,100,60, Color.GREY, algo.getGestorMovimiento().getTablero().getCasillas().get(15)));
		
		list.add(new CasillaVista(600,160,100,60, Color.YELLOW,algo.getGestorMovimiento().getTablero().getCasillas().get(16)));
		list.add(new CasillaVista(600,220,100,60, Color.MEDIUMPURPLE,algo.getGestorMovimiento().getTablero().getCasillas().get(17)));
		list.add(new CasillaVista(600,280,100,60, Color.GREEN,algo.getGestorMovimiento().getTablero().getCasillas().get(18)));
		list.add(new CasillaVista(600,340,100,60, Color.RED, algo.getGestorMovimiento().getTablero().getCasillas().get(19)));
		
		this.getChildren().addAll(new Rectangle(800,0,100,100));
		
		for(CasillaVista rec: list){
			this.getChildren().addAll(rec);
		}
	
		
		
	}

}
