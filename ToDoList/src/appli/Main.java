package appli;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner sc = new Scanner(System.in);
        String dtb_name = "lsa_Todolist";
        String dtb_user = "root";
        String dtb_psw = "";
        int idUtilisateur = 0;
        String option = "";

        // Connexion à la base de donnée
        Connection connexion = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/" + dtb_name, dtb_user, dtb_psw);

        System.out.println("Bienvenue sur l'application de gestion de votre To Do List !");
        while (!option.equals("quitter")) {
            System.out.println("Veuillez vous identifier pour accéder à l'application :");
            boolean verifconnex = false;
            while (!verifconnex) {
                PreparedStatement req = connexion.prepareStatement("SELECT login,id_utilisateur FROM utilisateur WHERE login = ? AND mdp = ?;");
                System.out.println("Saisir le login: ");
                req.setString(1, sc.nextLine());
                System.out.println("Saisir le mot de passe: ");
                req.setString(2, sc.nextLine());
                ResultSet reponse = req.executeQuery();
                if (reponse.next()) {
                    System.out.println("Bonjour" + reponse.getString(1) + "et bienvenue !");
                    verifconnex = true;
                } else {
                    System.out.println("Erreur lors de la connexion, la combinaison login/mot de passe n'a pas fonctionné");
                }
            }
            option = "";

            int ID = 0;
            while (!(option.equals("quitter")) || option.equals("deconnecter")) {
                boolean potion = false;
                while (!potion) {

                    System.out.println("Voici le menu principal: ");
                    System.out.println(" - (L)ister toutes vos listes");
                    //idéee a la place de l'option liste : //
                    // System.out.println(" - (V)oir votre profil");//
                    // affiche toutes ses infos et il peut selectionner les autres options //
                    System.out.println(" - (C)reer une nouvelle liste");
                    System.out.println(" - (S)upprimer une liste");
                    System.out.println(" - (A)jouter une personne à une liste");
                   // System.out.println(" - (M)odifier une liste");//
                    System.out.println(" - (Q)uitter l'application");
                    System.out.println(" - (D)econnexion");


                }
            }
        }
    }
}