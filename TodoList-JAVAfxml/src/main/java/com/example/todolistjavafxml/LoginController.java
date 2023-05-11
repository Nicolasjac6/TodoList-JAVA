package com.example.todolistjavafxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField usernameTextField;

    @FXML
    private PasswordField passwordTextField;

    @FXML
    private Label errorLabel;

    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();

        // Vérification de l'authentification de l'utilisateur
        if (authenticationService.authenticate(username, password)) {
            // Rediriger vers la page d'accueil
            // ...
        } else {
            errorLabel.setText("Nom d'utilisateur ou mot de passe incorrect");
        }
    }

}