/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresiones_lambda_keyevent;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author aldob
 */
public class T1_435ExpresionesLambdaKeyEvent extends Application {

    @Override
    public void start(Stage primaryStage) {

        //CONTENEDOR
        Pane root = new Pane();

        //COMPONENTES
        Text texto = new Text(20, 20, "A");
        
        /* DESBLOQUEA EL MOVIMIENTO DEL TEXTO*/
        texto.setFocusTraversable(true);
    

        //INSERCION DE ELEMENTOS
        root.getChildren().add(texto);

        //ESCENA
        Scene scene = new Scene(root, 300, 250);
        
        //EVENTOS

        texto.setOnKeyPressed(e -> {

            if (e.getCode() == KeyCode.DOWN) {
                texto.setY(texto.getY() + 10);
            } else if (e.getCode() == KeyCode.UP) {
                texto.setY(texto.getY()  - 10);
            } else if (e.getCode() == KeyCode.LEFT) {
                texto.setX(texto.getX()  - 10);
            } else if (e.getCode() == KeyCode.RIGHT) {
                texto.setX(texto.getX() + 10);
            } else if (e.getCode().isDigitKey() || e.getCode().isLetterKey()) {
                texto.setText(texto.getText() + e.getText());
            }

        });

        primaryStage.setTitle("ExpresionesLambda_KeyEvent");
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
