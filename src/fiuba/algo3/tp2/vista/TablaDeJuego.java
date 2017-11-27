package fiuba.algo3.tp2.vista;

import java.util.ArrayList;

import fiuba.algo3.tp2.controlador.AlgoPoly;
import javafx.scene.Parent;



public class TablaDeJuego extends Parent{
	
	public ArrayList<CasillaVista> list = new ArrayList<CasillaVista>();
	private AlgoPoly algo = new AlgoPoly();
	
	public TablaDeJuego()
	{
		list.add(new CasillaVista(1168,734,132,65,algo.getGestorMovimiento().getTablero().getCasillas().get(0)));
		list.add(new CasillaVista(1035,734,133,65,algo.getGestorMovimiento().getTablero().getCasillas().get(1)));
		list.add(new CasillaVista(901,734,133,65,algo.getGestorMovimiento().getTablero().getCasillas().get(2)));
		list.add(new CasillaVista(767,734,133,65,  algo.getGestorMovimiento().getTablero().getCasillas().get(3)));
		list.add(new CasillaVista(633,734,133,65 ,algo.getGestorMovimiento().getTablero().getCasillas().get(4)));
		list.add(new CasillaVista(500,734,133,65,algo.getGestorMovimiento().getTablero().getCasillas().get(5)));
		
		list.add(new CasillaVista(500,667,133,67,algo.getGestorMovimiento().getTablero().getCasillas().get(6)));
		list.add(new CasillaVista(500,600,133,67,algo.getGestorMovimiento().getTablero().getCasillas().get(7)));
		list.add(new CasillaVista(500,533,133,67,algo.getGestorMovimiento().getTablero().getCasillas().get(8)));
		list.add(new CasillaVista(500,466,133,67, algo.getGestorMovimiento().getTablero().getCasillas().get(9)));
		
		list.add(new CasillaVista(500,399,133,67, algo.getGestorMovimiento().getTablero().getCasillas().get(10)));
		list.add(new CasillaVista(633,399,133,67,algo.getGestorMovimiento().getTablero().getCasillas().get(11)));
		list.add(new CasillaVista(767,399,133,67 ,algo.getGestorMovimiento().getTablero().getCasillas().get(12)));
		list.add(new CasillaVista(901,399,133,67,algo.getGestorMovimiento().getTablero().getCasillas().get(13)));
		list.add(new CasillaVista(1035,399,133,67 ,algo.getGestorMovimiento().getTablero().getCasillas().get(14)));
		list.add(new CasillaVista(1168,399,132,67, algo.getGestorMovimiento().getTablero().getCasillas().get(15)));
		
		list.add(new CasillaVista(1168,466,132,67,algo.getGestorMovimiento().getTablero().getCasillas().get(16)));
		list.add(new CasillaVista(1168,533,132,67,algo.getGestorMovimiento().getTablero().getCasillas().get(17)));
		list.add(new CasillaVista(1168,600,132,67,algo.getGestorMovimiento().getTablero().getCasillas().get(18)));
		list.add(new CasillaVista(1168,667,132,67,algo.getGestorMovimiento().getTablero().getCasillas().get(19)));
		
		
		for(CasillaVista casilla: list){
			this.getChildren().addAll(casilla);
		}
	}

	public ArrayList<CasillaVista> getList() {
		return list;
	}

	public AlgoPoly getAlgo() {
		return algo;
	}
	
	

}
