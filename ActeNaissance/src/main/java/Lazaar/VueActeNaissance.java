package main.java.Lazaar;

import javafx.scene.control.*;

public class VueActeNaissance {
    // Initialisation des champs
    Label nomP = new Label("Nom père");
    Label prenomP = new Label("Prénom père");

    Label nomM = new Label("Nom mère");
    Label prenomM = new Label("Prénom mère");

    Label prenomPetit = new Label("Prénom enfant");
    Label dateNaissance = new Label("Date de naissance");
    Label lieuNaissance = new Label("Lieu de naissance");

    ComboBox<String> sexe = new ComboBox<>();
    Button creeActeNaissance = new Button("Créer Acte Naissance");

    // Constructeur
    public VueActeNaissance(Personne personne) {
        // Ajout des options à la ComboBox
        sexe.getItems().addAll("Homme", "Femme");
    }
}