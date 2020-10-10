package timelines;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.javafx.perf.PerformanceTracker;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author aldob
 */
public class Timelines extends Application {
        
    private static double ballSpeedX = 2;  
    private static double ballSpeedY= 2;

    @Override
    public void start(Stage primaryStage) {
        
        
        Group pane = new Group();

        // Bola que se usará para la animación
        Circle ball = new Circle(10);
        ball.setTranslateX(300 * 0.5);
        ball.setTranslateY(250 * 0.5);
        pane.getChildren().addAll(ball);

        // Etiqueta que mostrará el valor de frames por segundo (FPS) 
        Label label = new Label();
        label.setTranslateX(10);
        label.setTranslateY(10);
        pane.getChildren().addAll(label);
        
        //CREA LA ESCENA
        Scene scene = new Scene(pane, 300, 250);
        primaryStage.setTitle("Timeline");

        //Escuchador a incluir en el bucle de Timelines
        EventHandler<ActionEvent> eH = e -> { 
            // Mostrar la frecuencia de refresco FPS
            PerformanceTracker perfTracker = PerformanceTracker.getSceneTracker(scene);
            label.setText("FPS (Timeline) = " + perfTracker.getInstantFPS()); 

            // Cambiar la dirección de la bola si llega a los extremos 
            
            if (ball.getTranslateX() < ball.getRadius() || ball.getTranslateX() > 300-ball.getRadius()) {
                ballSpeedX *= -1;
              
            }
            
            ball.setTranslateX(ball.getTranslateX() + ballSpeedX);
            
 
            if(ball.getTranslateY() < ball.getRadius() || ball.getTranslateY() > 250-ball.getRadius()){
                ballSpeedY *=-1;
            }
            
            ball.setTranslateY(ball.getTranslateY() + ballSpeedY);
        };

            //Definimos el bucle con la duración, cada 5 milisegundos que son aproximadamente 60 FPS
            Timeline animation = new Timeline(new KeyFrame(Duration.millis(5), eH));
            animation.setCycleCount(Timeline.INDEFINITE);
            // iniciamos animation 
            animation.play();

 
            primaryStage.setScene(scene);
            primaryStage.show();
        } /**
                 * @param args the command line arguments
                 */

    public static void main(String[] args) {
        launch(args);
    }

}