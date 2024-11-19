package Lazaar;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Personne {
    
    private StringProperty nom;
    private StringProperty prenom;
    private IntegerProperty age;
    
    Personne(String nom, String prenom, int age) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom =  new SimpleStringProperty(prenom);
        this.age = new SimpleIntegerProperty(age);
    }
    public StringProperty nomProperty() {
        return nom;
    }
    public StringProperty prenomProperty() {
        return prenom;
    }
    public IntegerProperty ageProperty() {
        return age;
    }
    public void setNom(String nom) {
        this.nom.set(nom);
    }
    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }
    public void setAge(int age) {
        this.age.set(age);
    }
    @Override
    public String toString() {
        return "{" + "nom=" + nom.get() + ", prenom=" + prenom.get() + ", age=" + age.get() + '}';
    }
}
