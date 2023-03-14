import utilisateur_authentification.DAOUtilisateur;
import utilisateur_authentification.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class main {

    private static Connection conn;

    public static void main(String[] args) {
        try {
            // Se connecter à la base de données
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");

            // Créer les DAO
            DAOUtilisateur utilisateurDAO = new DAOUtilisateur(conn);
            ListeDAO listeDAO = new ListeDAO(conn);
            TacheDAO tacheDAO = new TacheDAO(conn);

            // Menu principal
            Scanner scanner = new Scanner(System.in);
            int choix;
            do {
                System.out.println("1. Connexion");
                System.out.println("2. Créer un compte");
                System.out.println("0. Quitter");
                choix = scanner.nextInt();
                scanner.nextLine();

                switch (choix) {
                    case 1:
                        // Connexion
                        System.out.println("Login :");
                        String login = scanner.nextLine();
                        System.out.println("Mot de passe :");
                        String mdp = scanner.nextLine();

                        Utilisateur utilisateur = utilisateurDAO(login, mdp);
                        if (utilisateur != null) {
                            System.out.println("Bienvenue " + utilisateur.getPrenom() + " " + utilisateur.getNom() + " !");
                            menuListes(utilisateur, listeDAO, tacheDAO, scanner);
                        } else {
                            System.out.println("Identifiants incorrects.");
                        }
                        break;
                    case 2:
                        // Création de compte
                        System.out.println("Nom :");
                        String nom = scanner.nextLine();
                        System.out.println("Prénom :");
                        String prenom = scanner.nextLine();
                        System.out.println("Login :");
                        login = scanner.nextLine();
                        System.out.println("Mot de passe :");
                        mdp = scanner.nextLine();

                        utilisateur = new Utilisateur(nom, prenom, login, mdp);
                        if (utilisateurDAO.create(utilisateur)) {
                            System.out.println("Compte créé !");
                        } else {
                            System.out.println("Erreur lors de la création du compte.");
                        }
                        break;
                    case 0:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix incorrect.");
                        break;
                }
            } while (choix != 0);

        } catch (SQLException e) {
            System.out.println("Erreur de connexion à la base de données : " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
            }
        }
    }

    private static Utilisateur utilisateurDAO(String login, String mdp) {
        return null;
    }

    private static void menuListes(Utilisateur utilisateur, ListeDAO listeDAO, TacheDAO tacheDAO, Scanner scanner) {
        int choix;
        do {
            System.out.println("1. Créer une liste");
            System.out.println("2. Afficher mes listes");
            System.out.println("0. Déconnexion");
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1:
                    // Créer une liste
                    System.out.println("Nom de la liste :");
                    String nomListe = scanner.nextLine();
                    System.out.println("Description de la liste : ");
                    String descriptionListe = scanner.nextLine();
                    Liste nouvelleListe = new Liste(nomListe, descriptionListe);
                    nouvelleListe.setUtilisateur(utilisateur);
                    listeDAO.create(nouvelleListe);
                    System.out.println("La liste a été créée avec succès !");
                    break;
                case 2:
                    // Afficher les listes de l'utilisateur connecté
                    List<Liste> listesUtilisateur = listeDAO.findByUtilisateur(utilisateur);
                    if (listesUtilisateur.isEmpty()) {
                        System.out.println("Aucune liste trouvée.");
                    } else {
                        for (Liste liste : listesUtilisateur) {
                            System.out.println("Liste n°" + liste.getId() + " : " + liste.getNom() + " - " + liste.getDescription());
                        }
                    }
                    break;
                case 0:
                    System.out.println("Déconnexion...");
                    break;
                default:
                    System.out.println("Choix invalide !");
                    break;
            }
        } while (choix != 0);

    }
}




