/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fadetransition;


import javafx.animation.FadeTransition;
import javafx.animation.Timeline;
import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.shape.Ellipse;

import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author aldob
 */
public class FadeTransitions extends Application {

    @Override
    public void start(Stage primaryStage) {

        //COMPONENTES
        Ellipse ellipse = new Ellipse(10, 10, 100, 75);
        ellipse.setFill(Color.RED);
        ellipse.setStroke(Color.BLACK);

        // FADE TRANSITION
        
        FadeTransition ft = new FadeTransition(Duration.millis(3000), ellipse);
        ft.setFromValue(1.0);
        ft.setToValue(0.1);
        ft.setCycleCount(Timeline.INDEFINITE);
        ft.setAutoReverse(true);
        ft.play();

        //EVENTOS
        ellipse.setOnMousePressed(e -> ft.pause());
        ellipse.setOnMouseReleased(e -> ft.play());

        //CONTENEDORES
        StackPane root = new StackPane();
        root.getChildren().add(ellipse);

        //SCENA
        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("FADE TRANSITION");
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
