package Lazaar;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class VueActeNaissance {
    VBox root;
    ScrollPane scrollPane = new ScrollPane();
    // Initialisation des champs
    Label nomP, prenomP, nomM, prenomM, prenomPetit, nomEnfant,age , sexLabel;
    TextField txtNomP, txtPrenomP, txtNomM, txtPrenomM, txtprenomPetit, txtnomPetit;

    Label dateNaissance = new Label("Date de naissance");
    DatePicker date = new DatePicker();
    Label lieuNaissance;
    TextField lieu;

    ComboBox<String> sexe = new ComboBox<>();
    Button creeActeNaissance = new Button("Créer Acte Naissance");

    // Constructeur
    public VueActeNaissance(PersonneActe personne) {
        // Ajout des options à la ComboBox
        sexe.getItems().addAll("Homme", "Femme");
        init(personne);
    }

    void init(PersonneActe personne) {
        root = new VBox();
        root.setAlignment(Pos.CENTER);
        root.setSpacing(10);
        // Champs pour le père
        nomP = new Label("Nom père");
        txtNomP = new TextField(personne.nom.get());

        prenomP = new Label("Prénom père");
        txtPrenomP = new TextField(personne.prenom.get());

        // Champs pour la mère
        nomM = new Label("Nom maman");
        txtNomM = new TextField();
        prenomM = new Label("Prénom maman");
        txtPrenomM = new TextField();

        // Champs pour l'enfant
        prenomPetit = new Label("Prénom enfant");
        txtprenomPetit = new TextField();

        lieuNaissance = new Label("Lieu de naissance");
        lieu = new TextField();
        sexLabel = new Label("Sexe");

        // Ajouter tous les champs au conteneur VBox
        root.getChildren().addAll(
            nomP, txtNomP, 
            prenomP, txtPrenomP, 
            nomM, txtNomM, 
            prenomM, txtPrenomM, 
            prenomPetit, txtprenomPetit, 
            dateNaissance, date,
            lieuNaissance, lieu,
            sexe,sexLabel,
            creeActeNaissance
        );
        
        creeActeNaissance.setOnAction((e) -> ouvrirActeNaissance());
        scrollPane.setContent(root);
        scrollPane.setFitToWidth(true);
    }

    private void ouvrirActeNaissance() {
        // Récupération des données
        Stage boiteDialog = new Stage();
        boiteDialog.initModality(Modality.APPLICATION_MODAL);
        boiteDialog.setTitle("Acte de naissance enregistré");

        VBox boite = new VBox();
        boite.setAlignment(Pos.CENTER);

        Label nomP = new Label("Nom père : " + txtNomP.getText());
        Label prenomP = new Label("Prenom père : " + txtPrenomP.getText());
        Label nomM = new Label("Nom maman : " + txtNomM.getText());
        Label prenomM = new Label("Prenom maman : " + txtPrenomM.getText());
        Label prenomPetit = new Label("Prenom petit : " + txtprenomPetit.getText());
        Label nomPetit = new Label("Nom de famille : " + txtNomP.getText());
        Label lieuNaissance = new Label("Lieu de naissance : " + lieu.getText());
        Label sexeLabel = new Label("Sexe : " + sexe.getValue());

        boite.getChildren().addAll(
            nomP, prenomP, 
            nomM, prenomM, 
            prenomPetit, nomPetit, 
            lieuNaissance, sexeLabel
            );

            Scene boiteScene = new Scene(boite, 400, 300);
        boiteDialog.setScene(boiteScene);

        boiteDialog.show();
        
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }
}
