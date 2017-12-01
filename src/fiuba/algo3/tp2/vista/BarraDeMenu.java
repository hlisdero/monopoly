package fiuba.algo3.tp2.vista;


import fiuba.algo3.tp2.vista.eventos.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;


public class BarraDeMenu extends MenuBar{

	
	 public BarraDeMenu() {
		 
		 
		 Menu menuOpcion = new Menu("Menu");

	     MenuItem opcionSalir = new MenuItem("Salir del Juego");
	        
	     OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
	     opcionSalir.setOnAction(opcionSalirHandler);

	     menuOpcion.getItems().addAll(opcionSalir);
	     
	     this.getMenus().addAll(menuOpcion);
	 }
	
}
