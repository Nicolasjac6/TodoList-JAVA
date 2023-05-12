package com.example.todolistjavafxml.todolistjavafxml;

import java.sql.SQLException;

public class DAOException extends Exception {
    public DAOException(String s, SQLException e) throws DAOException {

    }
    protected Object connexion;

    com.example.todolistjavafxml.todolistjavafxml.DAOUtilisateur utilisateurDAO = new com.example.todolistjavafxml.todolistjavafxml.DAOUtilisateur(connexion);

    private String login;
    private int mdp;

    com.example.todolistjavafxml.todolistjavafxml.Utilisateur utilisateur = utilisateurDAO.authentifier(login, mdp);

    {
        if (utilisateur != null) {
            // L'utilisateur est authentifié, on peut afficher le menu principal
        } else {
            // L'utilisateur n'a pas été trouvé, on affiche un message d'erreur et on redemande les identifiants
        }
    }
}
