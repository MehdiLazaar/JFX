package Lazaar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        
        PersonneActe p1 = new PersonneActe();
        
        // Créer la vue pour afficher la personne
        VueActeNaissance vue = new VueActeNaissance(p1);
        // Mettre un titre à la fenêtre
        stage.setTitle("Acte de naissance");
        var label = new Label("Mehdi Lazaar");
        Scene scene = new Scene(vue.getRoot(), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}