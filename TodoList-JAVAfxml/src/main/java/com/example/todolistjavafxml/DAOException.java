package com.example.todolistjavafxml;

import java.sql.SQLException;

public class DAOException extends Exception {
    public DAOException(String s, SQLException e) throws DAOException {

    }
    protected Object connexion;

    utilisateur_authentification.DAOUtilisateur utilisateurDAO = new utilisateur_authentification.DAOUtilisateur(connexion);

    private String login;
    private int mdp;

    utilisateur_authentification.Utilisateur utilisateur = utilisateurDAO.authentifier(login, mdp);

    {
        if (utilisateur != null) {
            // L'utilisateur est authentifié, on peut afficher le menu principal
        } else {
            // L'utilisateur n'a pas été trouvé, on affiche un message d'erreur et on redemande les identifiants
        }
    }
}
