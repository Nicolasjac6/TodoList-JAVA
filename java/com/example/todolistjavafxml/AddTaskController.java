package com.example.todolistjavafxml.todolistjavafxml;

public class AddTaskController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private ChoiceBox<TaskType> typeChoiceBox;

    @FXML
    private void handleAddButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        String description = descriptionTextArea.getText();
        TaskType type = typeChoiceBox.getValue();

        // Création de la nouvelle tâche
        Task newTask = new Task(name, description, type);
        taskService.addTaskToList(newTask, selectedList);

        // Fermer la fenêtre d'ajout
        // ...
    }

}
