package utilisateur_authentification;

import java.util.Scanner;

// Classe utilisateur.utilisateur_authentification pour gérer le processus d'authentification de l'utilisateur

public class Authentification {
    private utilisateur_authentification.DAOUtilisateur daoUtilisateur;
    protected Object connexion;

    public Authentification() {


        daoUtilisateur = new utilisateur_authentification.DAOUtilisateur(connexion);
    }

    public void authentifier() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue !");
        System.out.print("Entrez votre login : ");
        String login = scanner.nextLine();
        System.out.print("Entrez votre mot de passe : ");
        String mdp = scanner.nextLine();

        Utilisateur utilisateur = daoUtilisateur.trouverParLoginMdp(login, mdp);

        if (utilisateur != null) {
            System.out.println("Bienvenue, " + utilisateur.getNom() + " !");
            // Continuer l'exécution de l'application
        } else {
            System.out.println("Mauvais login ou mot de passe. L'application va se fermer.");
            System.exit(0);
        }
    }
}