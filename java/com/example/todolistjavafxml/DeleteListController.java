package com.example.todolistjavafxml.todolistjavafxml;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import java.util.Optional;

public class DeleteListController {

    @FXML
    private void handleDeleteButton() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de suppression");
        alert.setHeaderText("Supprimer la liste ?");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer cette liste ? Toutes les tâches associées seront également supprimées. Cette action est irréversible.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            // Supprimer la liste et les tâches associées de la base de données
            // ...

            // Fermer la fenêtre actuelle
            Stage stage = (Stage) deleteButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void handleCancelButton() {
        // Fermer la fenêtre actuelle
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}