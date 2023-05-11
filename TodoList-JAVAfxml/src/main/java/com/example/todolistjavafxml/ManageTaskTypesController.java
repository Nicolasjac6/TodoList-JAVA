package com.example.todolistjavafxml;

import javafx.scene.paint.Color;

public class ManageTaskTypesController {

    @FXML
    private TextField nameTextField;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private TableView<TaskType> taskTypeTableView;

    @FXML
    private TableColumn<TaskType, String> nameColumn;

    @FXML
    private TableColumn<TaskType, Color> colorColumn;

    @FXML
    private void initialize() {
        // Initialisation du tableau des types de tâches
        nameColumn.setCellValueFactory(new PropertyValueFactory<TaskType, String>("name"));
        colorColumn.setCellValueFactory(new PropertyValueFactory<TaskType, Color>("color"));
        taskTypeTableView.setItems(taskTypeService.getAllTaskTypes());
    }

    @FXML
    private void handleCreateButtonAction(ActionEvent event) {
        String name = nameTextField.getText();
        Color color = colorPicker.getValue();

        // Création du nouveau type de tâche
        TaskType newTaskType = new TaskType(name, color);
        taskTypeService.createTaskType(newTaskType);

        // Réinitialisation des champs de saisie
        nameTextField.setText("");
        colorPicker.setValue(Color.WHITE);

    }
}