package Lazaar;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Initialize Operations and VueOperation
        Operations operations = new Operations();
        VueOperation vueOperation = new VueOperation(operations);

        // Create scene and set stage
        var scene = new Scene(vueOperation.getView(), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Calculator App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
