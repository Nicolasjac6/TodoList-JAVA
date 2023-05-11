package com.example.todolistjavafxml;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class creerListe {
    @FXML
    private TextField nomField;
    @FXML private TextArea descriptionArea;

    private ListeDAO listeDAO; // Une instance de la classe ListeDAO
    private Object utilisateur;

    public void setListeDAO(ListeDAO listeDAO) {
        this.listeDAO = listeDAO;
    }

    @FXML
    private void creerListe() {
        String nom = nomField.getText();
        String description = descriptionArea.getText();

        if (nom.isEmpty()) {
            // Afficher un message d'erreur si le nom de la liste est vide
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Le nom de la liste ne peut pas être vide.");
            alert.showAndWait();
            return;
        }

        utilisateur_authentification.Liste liste = new utilisateur_authentification.Liste(nom, description, utilisateur);
        listeDAO.creerListe(liste); // Appeler la méthode creerListe de la classe ListeDAO pour ajouter la nouvelle liste dans la base de données

        // Fermer la fenêtre du formulaire
        Stage stage = (Stage) nomField.getScene().getWindow();
        stage.close();
    }
}
