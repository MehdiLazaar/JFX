package Lazaar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Lazaar.Vue.VuePersonne;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Créer une instance de Personne
        Personne p1 = new Personne("Lazaar", "Mehdi", 22);
        
        // Créer la vue pour afficher la personne
        VuePersonne vue = new VuePersonne(p1);

        // Créer une scène avec la vue comme racine
        Scene scene = new Scene(vue.getRoot(), 320, 240);

        // Configurer la scène et afficher la fenêtre
        stage.setScene(scene);
        stage.setTitle("Informations Personne");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
