/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlcircle;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author aldobg
 */
public class ControlCircle extends Application {

    Circle circle = new Circle(75);
    BorderPane root;

    @Override
    public void start(Stage primaryStage) {

       
        BorderPane root = new BorderPane();

        //COMPONENTE del top
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);

        
        //COMPONENTES DEL BOTTOM
        HBox hbox = new HBox();
        Button btAumentar = new Button("Aumentar");
        Button btReducir = new Button("Reducir");

        hbox.getChildren().addAll(btAumentar, btReducir);
        hbox.setAlignment(Pos.CENTER);

        //COLOCACION DE ELEMENTOS
        root.setCenter(circle);
        root.setBottom(hbox);

        //Relacion ENTRE BOTON Y HANDLER
        btAumentar.setOnAction(new AumentarHandler());
        btReducir.setOnAction(new ReducirHandler());

        //ANTES  root.getChildren().addAll(hBox, hbox);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("Control Circle");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    //IMPLEMENTACION INNER CLASS ES
    class AumentarHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {

            circle.setRadius(circle.getRadius() + 2);
        }

    }

    class ReducirHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent e) {
            if(circle.getRadius() > 2)
               circle.setRadius( circle.getRadius() - 2);   
            else 
                circle.setRadius(circle.getRadius());

        }
    }

}
