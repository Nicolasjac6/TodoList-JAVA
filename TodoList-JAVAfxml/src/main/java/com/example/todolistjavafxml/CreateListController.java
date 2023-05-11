package com.example.todolistjavafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class CreateListController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String description = descriptionTextArea.getText();

        // Création de la nouvelle liste
        List newList = new List(name, description);
        listService.createList(newList);

        // Fermer la fenêtre de création
        // ...
    }

}
