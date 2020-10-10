package anonymous_inner_class;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author aldob
 */
public class AnonymousInnerClass extends Application {

    @Override
    public void start(Stage primaryStage) {
        //
        //CONTENEDORES
        //
        //CAJA HBOX
        HBox hbox1 = new HBox();
        hbox1.setPadding(new Insets(10, 10, 10, 10));
        hbox1.setSpacing(10);
        hbox1.setAlignment(Pos.CENTER);
        //
        //COMPONENTES//
        //
        //BOTONES
        Button btnNuevo = new Button();
        Button btnAbrir = new Button();
        Button btnGuardar = new Button();
        Button btnImprimir = new Button();

        btnNuevo.setText("Nuevo");
        btnAbrir.setText("Abrir");
        btnGuardar.setText("Guardar");
        btnImprimir.setText("Imprimir");

        //
        //EVENTOS
        //
        //NUEVO
        btnNuevo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nuevo proceso");
            }
        });
        //ABRIR
        btnAbrir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                System.out.println("Abrir proceso");
            }
        }
        );
        //GUARDAR
        btnGuardar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                System.out.println("Guardar proceso");
            }
        }
        );
        //IMPRIMIR
        btnImprimir.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                System.out.println("Imprimir proceso");
            }
        }
        );

        //AÑADIR BOTONES AL HBOX
        hbox1.getChildren().add(btnNuevo);
        hbox1.getChildren().add(btnAbrir);
        hbox1.getChildren().add(btnGuardar);
        hbox1.getChildren().add(btnImprimir);

        Scene scene = new Scene(hbox1, 320, 50);

        primaryStage.setTitle("AnonymousHandlerDemo");
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
