package com.example.todolistjavafxml.todolistjavafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class ValidateTaskController {

    @FXML
    private Label taskNameLabel;

    @FXML
    private TextArea taskDescriptionTextArea;

    @FXML
    private void handleValidateButtonAction(ActionEvent event) {
        selectedTask.setDone(true);
        Object taskService;
        taskService.updateTask(selectedTask);

        // Fermer la fenêtre de validation
        // ...
    }

}