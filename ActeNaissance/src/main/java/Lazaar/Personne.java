package main.java.Lazaar;

import javafx.beans.property.*;

public class Personne {
    public StringProperty nom, prenom;
    public StringProperty sexe;
    public IntegerProperty age;

    
    Personne(String nom, String prenom, String sexe, int age) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.sexe = new SimpleStringProperty(sexe);
        this.age = new SimpleIntegerProperty(age);
    }
    /**
     * Initialize the Personne object.
     * <p>
     * If any of the parameters are invalid, an
     * {@link IllegalArgumentException} is thrown.
     * @throws IllegalArgumentException if any of the parameters are invalid.
     */
    void init() {
        if(nom.get() == null && prenom.get() == null){
            throw new IllegalArgumentException("Inconnue");
        } else if(age.get() < 0){
            throw new IllegalArgumentException("L'age ne peut pas etre negatif");
        } else if (sexe.get() == null){
            throw new IllegalArgumentException("Homme ou Femme");
        }
    }
    /**
     * Check if the sexe is "Homme".
     * @return true if sexe is "Homme", false otherwise.
     */
    boolean petitMale(){
        if(sexe.get().equals("Homme")){
            return true;
        }else {
            return false;
        }
    }
    // Les Getters

    /**
     * Return the StringProperty of the nom of the Personne.
     * @return the StringProperty of the nom of the Personne.
     */
    StringProperty nomProperty() {
        return nom;
    }

    /**
     * Return the StringProperty of the prenom of the Personne.
     * @return the StringProperty of the prenom of the Personne.
     */
    
    /**
     * Return the StringProperty of the prenom of the Personne.
     * @return the StringProperty of the prenom of the Personne.
     */
    StringProperty prenomProperty(){
        return prenom;
    }
    /**
     * Return the BooleanProperty of the sexe of the Personne.
     * @return the BooleanProperty of the sexe of the Personne.
     */
    
/**
 * Return the BooleanProperty of the sexe of the Personne.
 * @return the BooleanProperty of the sexe of the Personne.
 */
    StringProperty sexeProperty(){
        return sexe;
    }
    /**
     * Return the IntegerProperty of the age of the Personne.
     * @return the IntegerProperty of the age of the Personne.
     */
    IntegerProperty ageProperty(){
        return age;
    }
    // Les Setters
    
/**
 * Sets the nom property of the Personne.
 * 
 * @param nom the StringProperty to set as the nom of the Personne.
 */
    public void setNom(StringProperty nom) {
        this.nom = nom;
    }

    /**
     * Sets the prenom property of the Personne.
     * 
     * @param prenom the StringProperty to set as the prenom of the Personne.
     */
    public void setPrenom(StringProperty prenom) {
        this.prenom = prenom;
    }
/**
 * Sets the sexe property of the Personne.
 *
 * @param sexe the StringProperty to set as the sexe of the Personne.
 */
    public void setSexe(StringProperty sexe) {
        this.sexe = sexe;
    }
/**
 * Sets the age property of the Personne.
 *
 * @param age the IntegerProperty to set as the age of the Personne.
 */
    public void setAge(IntegerProperty age) {
        this.age = age;
    }
}
