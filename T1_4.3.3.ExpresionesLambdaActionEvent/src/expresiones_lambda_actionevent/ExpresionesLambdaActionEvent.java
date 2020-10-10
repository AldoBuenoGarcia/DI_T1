/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones_lambda_actionevent;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.xml.stream.EventFilter;
import javax.xml.stream.events.XMLEvent;



/**
 *
 * @author aldob
 */
public class ExpresionesLambdaActionEvent extends Application {
    
    TextField tfTasaInteresAnual;
    TextField tfNAnios;
    TextField tfPrestamo;
    TextField tfPagoMensual;
    TextField tfTotal;
    @Override
    public void start(Stage primaryStage) {
        
        
        //
        //COMPONENTES
        //
        //labels
        Label lbTasaInteresAnual=  new Label("Tasa de interés anual: ");
        Label lbNAnios = new Label("Nº años: ");
        Label lbPrestamo = new Label("Cantidad del préstamo: ");
        Label lbPagoMensual = new Label("Pago mensual: ");
        Label lbTotal = new Label("Total a pagar: ");
        
        //textfields
        tfTasaInteresAnual = new TextField();
        tfTasaInteresAnual.setAlignment(Pos.BASELINE_RIGHT);
 
        tfNAnios = new TextField();
        tfNAnios.setAlignment(Pos.BASELINE_RIGHT);

        tfPrestamo = new TextField();
        tfPrestamo.setAlignment(Pos.BASELINE_RIGHT);

        tfPagoMensual = new TextField();
        tfPagoMensual.setAlignment(Pos.BASELINE_RIGHT);
        tfPagoMensual.setEditable(false);
        
        tfTotal = new TextField();
        tfTotal.setAlignment(Pos.BASELINE_RIGHT);
        tfTotal.setEditable(false);     
        //boton
        Button btnCalcular = new Button("Calcular");
        
        
        //
        //CONTENEDORES
        //
        //GRIDPANE
        GridPane gridpane = new GridPane();
        //Scene scene = new Scene(gridpane, 300, 250);
        
        //INSERCION DE ELEMTOS EN CONTENEDORES
        gridpane.addRow(0, lbTasaInteresAnual,tfTasaInteresAnual);
        gridpane.addRow(1, lbNAnios,tfNAnios);
        gridpane.addRow(2, lbPrestamo,tfPrestamo);
        gridpane.addRow(3, lbPagoMensual,tfPagoMensual);
        gridpane.addRow(4, lbTotal,tfTotal);
        gridpane.add(btnCalcular, 1, 6);
      
        //PROPIEDADES DE LOS ELEMENTOS DENTRO DE GRIDPANE
        //MARGEN
        GridPane.setMargin(tfTasaInteresAnual, new Insets(10, 10, 0, 0));
        GridPane.setMargin(lbTasaInteresAnual, new Insets(10, 0, 0, 20));
        
        GridPane.setMargin(tfNAnios, new Insets(4, 10, 0, 0));
        GridPane.setMargin(lbNAnios, new Insets(4, 0, 0, 20));
        
        GridPane.setMargin(tfPrestamo, new Insets(4, 10, 0, 0));
        GridPane.setMargin(lbPrestamo, new Insets(4, 0, 0, 20));
        
        GridPane.setMargin(tfPagoMensual, new Insets(4, 10, 0, 0));
        GridPane.setMargin(lbPagoMensual, new Insets(4, 0, 0, 20));
  
        GridPane.setMargin(tfTotal, new Insets(4, 10, 0, 0));
        GridPane.setMargin(lbTotal, new Insets(4, 0, 0, 20));
        
        GridPane.setMargin(btnCalcular, new Insets(4, 0, 0, 90));

     
        
        //EVENTOS
        //EVENTO BOTONCALCULAR al pulsar
        btnCalcular.setOnAction(e->{
                           
            double tasaintAnual;
            double anios;                  
            double totalPrestamo;
                  
            double total = 0;
            if (tfTasaInteresAnual.getText().isEmpty() ) {
                tasaintAnual = 0;
            }else{
             tasaintAnual = Double.parseDouble(tfTasaInteresAnual.getText());
            }
            if (tfNAnios.getText().isEmpty()) {
                anios = 0;
            }else{
            anios = Double.parseDouble(tfNAnios.getText());    
            }
            if (tfPrestamo.getText().isEmpty()) {
                totalPrestamo = 0;
            }else{
                totalPrestamo = Double.parseDouble(tfPrestamo.getText());
            }
                         
 
                  
                  double pagoMensual = 0;
                  
                  double r = tasaintAnual / (100 * 12);
                  
                  pagoMensual = (totalPrestamo * r) / (1 - (Math.pow(1 + r, -12 * anios)));

                  //redondeo a 2 decimales
                  //Mantener el valor real para operaciones
                  double pagoMensualReal = pagoMensual;
                  
                  pagoMensual = Math.round(pagoMensual * 100.0) / 100.0;
                  
            total = pagoMensualReal * 12 * anios;

            total = Math.round(total * 100.0) / 100.0;

            tfPagoMensual.setText("$" + String.valueOf(pagoMensual));

            tfTotal.setText("$" + String.valueOf(total));

        });
        
        //filtro de UN CAMPO ANTES DE HACER EL FILTRO GENERICO
        /*
        tfTasaInteresAnual.addEventFilter(KeyEvent.KEY_TYPED, e -> {

            if (e.getCharacter().compareTo(",") == 0 || e.getCharacter().compareTo(".") == 0) {
                tfTasaInteresAnual.setText(tfTasaInteresAnual.getText() + ".");
                tfTasaInteresAnual.positionCaret(tfTasaInteresAnual.getLength());
                e.consume();
                //EL 8 INDICA LA TECLA DE RETROCESO PARA QUE NO LA CONSIDERE NO NUMERO
            } else if (e.getCharacter().compareTo("-") == 0) {
            } else if (Character.isAlphabetic(e.getCharacter().charAt(0)) && !(e.getCharacter().charAt(0) == 8)) {
                System.out.println("La letra: " + e.getCharacter() + ", no  está permitido.");
                System.out.println("Introduca solo numeros por favor");

                e.consume();
            }/
        });*/
        
        //AÑADIR ELEMENTOS AL FILTRO GENERICO
        
        tfNAnios.setOnKeyTyped(new TxFieldFiltro());
        tfPagoMensual.setOnKeyTyped(new TxFieldFiltro());
        tfPrestamo.setOnKeyTyped(new TxFieldFiltro());
        tfTasaInteresAnual.setOnKeyTyped(new TxFieldFiltro());
        tfTotal.setOnKeyTyped(new TxFieldFiltro());
        //ESCENA Y ESCENARIO
        Scene scene = new Scene(gridpane, 320, 250);


        primaryStage.setTitle("ExpresionLambda ActionEvent");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
    //INNER CLASS
    class TxFieldFiltro implements EventHandler<KeyEvent> {

        @Override
        public void handle(KeyEvent event) {
            if (event.getCharacter().compareTo(",") == 0 || event.getCharacter().compareTo(".") == 0) {
                tfTasaInteresAnual.setText(tfTasaInteresAnual.getText() + ".");
                tfTasaInteresAnual.positionCaret(tfTasaInteresAnual.getLength());
                event.consume();
                //EL 8 INDICA LA TECLA DE RETROCESO PARA QUE NO LA CONSIDERE NO NUMERO
            } else if (event.getCharacter().compareTo("-") == 0) {
            } else if (Character.isAlphabetic(event.getCharacter().charAt(0)) && !(event.getCharacter().charAt(0) == 8)) {
                System.out.println("La letra: " + event.getCharacter() + ", no  está permitido.");
                System.out.println("Introduca solo numeros por favor");

                event.consume();
            }
        }

    }

    //FIN CLASS
}
