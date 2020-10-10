/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package path_transition_in_animation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author aldob
 */
public class PathTransitionInAnimation extends Application {

    @Override
    public void start(Stage primaryStage) {

        //OBJETOS GEOMETRICOS
        Rectangle rectangulo = new Rectangle(30, 50);
        rectangulo.setFill(Color.GOLD);

        Circle circulo = new Circle(150, 120, 70);
        circulo.setFill(Color.TRANSPARENT);
        circulo.setStroke(Color.BLACK);
        circulo.setStrokeWidth(3);

        // CREACION DEL PATH TRANSITION
        //USAR LA RUTA COMPLETA DE LA CLASE O NO FUNCIONA !
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(circulo);
        pt.setNode(rectangulo);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        
        //CUANDO TERMINA INVIERTE EL PATH
        pt.setAutoReverse(true);


        pt.play();

        //EVENTOS
        circulo.setOnMousePressed(e -> pt.pause());
        circulo.setOnMouseReleased(e -> pt.play());

        //CONTENEDORES
        Group root = new Group();
        root.getChildren().addAll(circulo, rectangulo);

        //SCENA
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("PathTransition");
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
