package Lazaar.Vue;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.input.KeyEvent;
import Lazaar.Personne;

public class VuePersonne {
    
    private VBox root; // Le conteneur principal
    private Label labelNom;
    private Label labelPrenom;
    private Label labelAge;

    // Constructeur pour afficher les informations de la personne
    public VuePersonne(Personne personne) {
        init(personne);
    }

    private void init(Personne personne) {
        root = new VBox(10); // Espacement de 10px entre les éléments

        // Création des labels et des TextField/Spinner pour chaque propriété de Personne
        labelNom = new Label("Nom: ");
        TextField txtNom = new TextField(personne.nomProperty().get());
        
        labelPrenom = new Label("Prénom: ");
        TextField txtPrenom = new TextField(personne.prenomProperty().get());

        labelAge = new Label("Âge: ");
        Spinner<Integer> spinnerAge = new Spinner<>(0, 100, personne.ageProperty().get());

        // Mise à jour des propriétés de la Personne lorsque l'utilisateur modifie les champs
        txtNom.setOnKeyReleased((KeyEvent e) -> personne.setNom(txtNom.getText()));
        txtPrenom.setOnKeyReleased((KeyEvent e) -> personne.setPrenom(txtPrenom.getText()));
        spinnerAge.valueProperty().addListener((obs, oldValue, newValue) -> personne.setAge(newValue));

        // Création des boutons dans un HBox (disposition horizontale)
        HBox hboxButtons = new HBox(10); // Espacement de 10px entre les boutons
        Button btnQuitter = new Button("Quitter");
        btnQuitter.setOnAction(e -> System.exit(0));
        Button btnEnregistrer = new Button("Enregistrer");
        btnEnregistrer.setOnAction(e -> System.out.println("Personne enregistrée : " + personne.toString()));
        
        // Ajouter les boutons dans le HBox
        hboxButtons.getChildren().addAll(btnEnregistrer, btnQuitter);

        // Ajouter les éléments (champs de texte, spinner, et boutons) au VBox
        root.getChildren().addAll(
            labelNom, txtNom, 
            labelPrenom, txtPrenom, 
            labelAge, spinnerAge, 
            hboxButtons // Ajouter les boutons sous les autres éléments
        );
    }

    // Getter pour la racine (VBox) afin de l'ajouter à une scène
    public VBox getRoot() {
        return root;
    }
}
