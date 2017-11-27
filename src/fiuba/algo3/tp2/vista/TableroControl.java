package fiuba.algo3.tp2.vista;



import fiuba.algo3.tp2.vista.eventos.BotonComprarHandler;
import fiuba.algo3.tp2.vista.eventos.BotonFinalizarTurnoHandler;
import fiuba.algo3.tp2.vista.eventos.BotonTirarDadosHandler;
import fiuba.algo3.tp2.vista.eventos.BotonVenderHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;

public class TableroControl extends Parent{
	
	TerrenoVista terreno = new TerrenoVista();
	DatosJugador datos = new DatosJugador();
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	Button venderPropiedad = new Button("Vender propiedad");
	
	private TurnoJugador turnoJugador = new TurnoJugador();
	
	private int sizeListaJugador = turnoJugador.getListaJugadores().size();
	
	
	
	public TableroControl(){

		this.setLayoutComponents();


		BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(turnoJugador, terreno);
       	tirarDados.setOnAction(tirarDadosHandler);
       	
       	BotonComprarHandler comprarHandler = new BotonComprarHandler(turnoJugador.getJugadorGenerico(), terreno);
    	comprarPropiedad.setOnAction(comprarHandler);
    	//comprarPropiedad.setDisable(true);	
    	
    	BotonVenderHandler venderHandler = new BotonVenderHandler(turnoJugador.getJugadorGenerico(), terreno);
    	venderPropiedad.setOnAction(venderHandler);

       	BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(turnoJugador, turnoJugador.getJugadorGenerico(), sizeListaJugador);
       	finalizarTurno.setOnAction(finalizarHandler);
		//tirarDados.setDisable(false);
		//comprarPropiedad.setDisable(false);
       	
       	this.getChildren().addAll(tirarDados,finalizarTurno,comprarPropiedad, venderPropiedad);
       	this.getChildren().add(datos);
       	this.getChildren().add(terreno);
		this.getChildren().add(turnoJugador);
	}
	
	
	
	public void setLayoutComponents()
	{
		tirarDados.setLayoutX(570);
		tirarDados.setLayoutY(850);

		finalizarTurno.setLayoutX(670);
		finalizarTurno.setLayoutY(850);

		comprarPropiedad.setLayoutX(900);
		comprarPropiedad.setLayoutY(850);
		
		venderPropiedad.setLayoutX(1100);
		venderPropiedad.setLayoutY(850);
	}

}
