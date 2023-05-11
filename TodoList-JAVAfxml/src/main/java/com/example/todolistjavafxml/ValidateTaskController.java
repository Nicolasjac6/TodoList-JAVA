package com.example.todolistjavafxml;

public class ValidateTaskController {

    @FXML
    private Label taskNameLabel;

    @FXML
    private TextArea taskDescriptionTextArea;

    @FXML
    private void handleValidateButtonAction(ActionEvent event) {
        selectedTask.setDone(true);
        taskService.updateTask(selectedTask);

        // Fermer la fenêtre de validation
        // ...
    }

}