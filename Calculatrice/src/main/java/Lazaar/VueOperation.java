package Lazaar;

import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

public class VueOperation {
    private GridPane grid; // Le conteneur principal
    public Button button = new Button("Operate");
    public TextField textf1 = new TextField();
    public TextField textf2 = new TextField();
    public ComboBox<String> combo = new ComboBox<>();
    public TextField result = new TextField();
    private Operations operations;

    public VueOperation(Operations operations) {
        this.operations = operations;
        init();
    }

    public void init() {
        // Initialisation de la grille
        grid = new GridPane();
        grid.setHgap(10); // Espacement horizontal
        grid.setVgap(10); // Espacement vertical

        // Configure les éléments de l'interface utilisateur
        result.setEditable(false); // Champ résultat non modifiable
        combo.getItems().addAll("+", "-", "*", "/", "%", "^");

        // Ajout des éléments à la grille
        grid.add(new Label("Number 1 :"), 0, 0);
        grid.add(textf1, 1, 0);
        grid.add(new Label("Number 2 :"), 0, 1);
        grid.add(textf2, 1, 1);
        grid.add(new Label("Operation :"), 0, 2);
        grid.add(combo, 1, 2);
        grid.add(new Label("Result :"), 0, 4);
        grid.add(button, 1, 3);
        grid.add(result, 1, 4);
        

        // Liaison entre les champs et les propriétés de l'objet Operations
        textf1.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                operations.nb1Property().set(Integer.parseInt(newVal));
            } catch (NumberFormatException e) {
                operations.nb1Property().set(0);
            }
        });

        textf2.textProperty().addListener((obs, oldVal, newVal) -> {
            try {
                operations.nb2Property().set(Integer.parseInt(newVal));
            } catch (NumberFormatException e) {
                operations.nb2Property().set(0);
            }
        });

        combo.valueProperty().addListener((obs, oldVal, newVal) -> operations.expressionProperty().set(newVal));

        operations.resultProperty().addListener((obs, oldVal, newVal) -> result.setText(newVal));

        // Action du bouton
        button.setOnAction(e -> operations.init());
    }

    // Méthode pour récupérer la vue (grille complète)
    public GridPane getView() {
        return grid;
    }
}
