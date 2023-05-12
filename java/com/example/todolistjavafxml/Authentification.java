package com.example.todolistjavafxml.todolistjavafxml;

import java.util.Scanner;

// Classe utilisateur.utilisateur_authentification pour gérer le processus d'authentification de l'utilisateur

public class Authentification {
    private com.example.todolistjavafxml.todolistjavafxml.DAOUtilisateur daoUtilisateur;
    protected Object connexion;

    public Authentification() {


        daoUtilisateur = new com.example.todolistjavafxml.todolistjavafxml.DAOUtilisateur(connexion);
    }

    public void authentifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue !");
        System.out.print("Entrez votre login : ");
        String login = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String mdp = scanner.nextLine();

        com.example.todolistjavafxml.todolistjavafxml.Utilisateur utilisateur = daoUtilisateur.trouverParLoginMdp(login, mdp);

        if (utilisateur != null) {
            System.out.println("Bienvenue, " + utilisateur.getNom() + " !");
            // Continuer l'exécution de l'application
        } else {
            System.out.println("Mauvais login ou mot de passe. L'application va se fermer.");
            System.exit(0);
        }
    }
}