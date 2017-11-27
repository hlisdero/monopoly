package fiuba.algo3.tp2.vista;

import java.util.ArrayList;


import fiuba.algo3.tp2.controlador.AlgoPoly;
import fiuba.algo3.tp2.modelo.Propiedad;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.StageStyle;




public class TableroDeJuego extends Parent{
	
	private AlgoPoly algo = new AlgoPoly();
	public ArrayList<CasillaVista> list = new ArrayList<CasillaVista>();
	
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	
	private int sumaDados;
	public ArrayList<JugadorVista> listaJugadores = new ArrayList<JugadorVista>();
	private JugadorVista jugadorGenerico;
	JugadorVista J1 = new JugadorVista(algo.getGestorTurnos().proximoJugador(), algo.getGestorMovimiento().getTablero().getCasillas().indexOf(algo.getGestorMovimiento().getTablero().getCasillaInicial()));
	JugadorVista J2 = new JugadorVista(algo.getGestorTurnos().proximoJugador(), algo.getGestorMovimiento().getTablero().getCasillas().indexOf(algo.getGestorMovimiento().getTablero().getCasillaInicial()));
	JugadorVista J3 = new JugadorVista(algo.getGestorTurnos().proximoJugador(), algo.getGestorMovimiento().getTablero().getCasillas().indexOf(algo.getGestorMovimiento().getTablero().getCasillaInicial()));
	private int x=listaJugadores.size();
	private TableView<String> table = new TableView<String>();

	
	public TableroDeJuego(StackPane root){
	
			
		ImageView image = new ImageView ("File:images/tablero.png ");
		image.setLayoutX(500);
		image.setLayoutY(400);
		image.setFitWidth(800);
		image.setFitHeight(400);
		
		this.getChildren().add(image);
		
		
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
		
		
		
		listaJugadores.add(J1);
		listaJugadores.add(J2);
		listaJugadores.add(J3);
		jugadorGenerico= listaJugadores.get(0);
		
		table.setLayoutX(50);
		table.setLayoutY(400);

		TableColumn colJugador1 = new TableColumn("Jugador 1");
		//firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		colJugador1.setMinWidth(100);
		TableColumn colJugador2 = new TableColumn("Jugador 2");
	//	lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		colJugador2.setMinWidth(100);
		TableColumn colJugador3 = new TableColumn("Jugador 3");
	//	phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
		colJugador3.setMinWidth(100);

		//table.setItems(data);
		table.getColumns().addAll(colJugador1, colJugador2, colJugador3);
		this.getChildren().add(table);
		tirarDados.setLayoutX(700);
		tirarDados.setLayoutY(500);
		this.getChildren().add(tirarDados);
		
		finalizarTurno.setLayoutX(65);
		finalizarTurno.setLayoutY(350);
		this.getChildren().add(finalizarTurno);

		
		comprarPropiedad.setLayoutX(200);
		comprarPropiedad.setLayoutY(350);
		this.getChildren().add(comprarPropiedad);
		
		J1.asignarPosicion(list.get(0).getPosX(), list.get(0).getPosY());
		J2.asignarPosicion(list.get(0).getPosX(), list.get(0).getPosY());
		J3.asignarPosicion(list.get(0).getPosX(), list.get(0).getPosY());


       	
       	
       	//Button tirar dados
       	tirarDados.setOnMouseClicked(e ->{
	      
	          	int numeroDeCasilla = jugadorGenerico.getNumeroCasilla();
	          	
	          	sumaDados = algo.getGestorTurnos().proximoJugador().tirarDados().getSuma();
	          	System.out.println(sumaDados);
	          	numeroDeCasilla += sumaDados;
	          	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
	          	dialogoAlerta.setTitle("Resultado dados");
	          	dialogoAlerta.setContentText("DADOS:" + sumaDados);
	          	dialogoAlerta.initStyle(StageStyle.UTILITY);
	          	dialogoAlerta.showAndWait();
	          	
	          	if(numeroDeCasilla > list.size()){numeroDeCasilla -= list.size() + 1;}
	          	
	          	jugadorGenerico.setNumeroCasilla(numeroDeCasilla);

	          	
	          	algo.getGestorMovimiento().mover(jugadorGenerico.getValorJugador());
	          	

	          	jugadorGenerico.setTranslateX(list.get(numeroDeCasilla).getPosX() + jugadorGenerico.posReferencia());

	          	jugadorGenerico.setTranslateY(list.get(numeroDeCasilla).getPosY());
	           	
	          	algo.getGestorMovimiento().mover(jugadorGenerico.getValorJugador(), list.get(jugadorGenerico.getNumeroCasilla()).getValorCasilla());
	          	
	          	tirarDados.setDisable(true);
	            });
       	
       	//button comprar prop   	
       	comprarPropiedad.setOnMouseClicked(e-> {
       		jugadorGenerico.getValorJugador().comprar((Propiedad)list.get(jugadorGenerico.getNumeroCasilla()).getValorCasilla());
       		System.out.println(jugadorGenerico.getValorJugador().getCapital());
       			comprarPropiedad.setDisable(true);
			
	
       		});
       	
       	//button finalizar turno
       	finalizarTurno.setOnMouseClicked(e-> {x=x+ 1;
       				jugadorGenerico = listaJugadores.get(x%3);
       				tirarDados.setDisable(false);
       				comprarPropiedad.setDisable(false);
       			
       	
       		});
       	
       	
		
		for(CasillaVista rec: list){
			this.getChildren().addAll(rec);
		}
	
		this.getChildren().addAll(J1,J2,J3);
		
		
		
	}

}
