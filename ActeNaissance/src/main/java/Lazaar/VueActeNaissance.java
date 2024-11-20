package Lazaar;

import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
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
            sexLabel,sexe,
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
        Label dateNaissance = new Label("Date de naissance : " + date.getValue());
        Label sexeLabel = new Label("Sexe : " + sexe.getValue());
        Button btnTelecharger = new Button("Telecharger votre Acte de naissance");
        btnTelecharger.setOnAction((e) -> {
            // Choisir le fichier avec FileChooser
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
            // Ouvrir une boîte de dialogue pour choisir où sauvegarder le fichier
            File selectedFile = fileChooser.showSaveDialog(null);

            // Sauvegarder le fichier
            if(selectedFile!= null){
                try{
                    BufferedWriter ecrire = new BufferedWriter(new FileWriter(selectedFile));
                    ecrire.write("Nom père : " + txtNomP.getText());
                    ecrire.newLine();
                    ecrire.write("Prenom père : " + txtPrenomP.getText());
                    ecrire.newLine();
                    ecrire.write("Nom maman : " + txtNomM.getText());
                    ecrire.newLine();
                    ecrire.write("Prenom maman : " + txtPrenomM.getText());
                    ecrire.newLine();
                    ecrire.write("Prenom bébé : " + txtprenomPetit.getText());
                    ecrire.newLine();
                    ecrire.write("Nom de famille : " + txtNomP.getText());
                    ecrire.newLine();
                    ecrire.write("Lieu de naissance : " + lieu.getText());
                    ecrire.newLine();
                    ecrire.write("Date de naissance : " + date.getValue());
                    ecrire.newLine();
                    ecrire.write("Sexe : " + sexe.getValue());
                    ecrire.close();
                } catch (IOException ex) {
                    System.out.println("Une erreur s'est produite lors de la sauvegarde du fichier.");
                }
            }
        });

        boite.getChildren().addAll(
            nomP, prenomP, 
            nomM, prenomM, 
            prenomPetit, nomPetit, 
            lieuNaissance, sexeLabel,
            btnTelecharger
        );

        Scene boiteScene = new Scene(boite, 400, 300);
        boiteDialog.setScene(boiteScene);

        boiteDialog.show();
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }
}
