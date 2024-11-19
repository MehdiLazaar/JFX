package Lazaar;

import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class VueActeNaissance {
    VBox root;
    ScrollPane scrollPane = new ScrollPane();
    // Initialisation des champs
    Label nomP, prenomP, nomM, prenomM, prenomPetit, nomEnfant,age , sexLabel;
    TextField txtNomP, txtPrenomP, txtNomM, txtPrenomM, txtprenomPetit, txtnomPetit;

    Label dateNaissance = new Label("Date de naissance");
    DatePicker date = new DatePicker();
    Label lieuNaissance;

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
        TextField lieu = new TextField();
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
        
        scrollPane.setContent(root); // Le contenu du ScrollPane est le VBox
        scrollPane.setFitToWidth(true);
    }

    public ScrollPane getScrollPane() {
        return scrollPane;
    }
}
