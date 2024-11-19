package main.java.Lazaar;

import javax.swing.ComboBoxEditor;
import javax.swing.JLabel;

public class VueActeNaissance {
    JLabel nomP = JLabel();
    JLabel prenomP = JLabel();

    JLabel nomM = JLabel();
    JLabel prenomM = JLabel();

    JLabel prenomPetit = new JLabel();
    JLabel dateNaissance = JLabel();
    JLabel lieuNaissance = JLabel();

    ComboBoxEditor sexe = new ComboBoxEditor();
    Button creeActeNaissance = new Button("Cree Acte Naissance");

    VueActeNaissance(Personne personne) {

    }
}
