package com.example.todolistjavafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ListeController {

    @FXML
    private TextField txtNomListe;

    @FXML
    private TextArea txtDescriptionListe;

    @FXML
    private Button btnCreerListe;

    private utilisateur_authentification.Utilisateur utilisateur;

    public void setUtilisateur(utilisateur_authentification.Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @FXML
    public void creerListe(ActionEvent event) {
        String nomListe = txtNomListe.getText();
        String descriptionListe = txtDescriptionListe.getText();

        // Vérifier que le nom de la liste est renseigné
        if (nomListe == null || nomListe.trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Veuillez saisir un nom pour la liste.");
            alert.showAndWait();
            return;
        }

        // Créer la nouvelle liste
        utilisateur_authentification.Liste nouvelleListe = new utilisateur_authentification.Liste(nomListe, descriptionListe, utilisateur);
        boolean resultat = ListeDAO.create(nouvelleListe);

        if (resultat) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "La liste a été créée avec succès.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Une erreur est survenue lors de la création de la liste.");
            alert.showAndWait();
        }
    }
}