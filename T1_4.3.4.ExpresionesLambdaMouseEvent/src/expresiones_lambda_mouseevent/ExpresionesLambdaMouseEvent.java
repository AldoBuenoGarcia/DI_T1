package expresiones_lambda_mouseevent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author aldob
 */
public class ExpresionesLambdaMouseEvent extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        
        //TAMAÑO DEL NODO PANE
        root.setPrefSize(0,0);

        //texto y propiedades
        Text texto = new Text("Programing is fun");
        texto.setFont(Font.font("Arial", FontWeight.NORMAL, 20));
        texto.setFocusTraversable(true);
        
        
        root.getChildren().add(texto);
        
        
        //mover Pane al centro de la ventana
        root.setTranslateY(175);
        root.setTranslateX(140);
         
        //EVENTO
        texto.setOnMouseDragged(e -> {

           texto.setX(e.getX());
           texto.setY(e.getY());
           e.consume();
        });
        
        Scene scene = new Scene(root, 400, 350);
        
        primaryStage.setTitle("ExpresionesLambda_MOUSE EVENT");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}