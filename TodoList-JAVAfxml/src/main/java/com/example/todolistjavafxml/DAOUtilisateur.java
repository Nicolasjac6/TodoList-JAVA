
import com.example.todolistjavafxml.DAOException;

import java.sql.*;

// Classe utilisateur.DAOUtilisateur_authentification pour la communication avec la base de données pour les opérations liées aux utilisateurs
public class DAOUtilisateur {
        protected Connection connexion;

        public DAOUtilisateur(Object connexion) {
            // Connexion à la base de données
            String url = "jdbc:mysql://localhost:3306/mydatabase";
            String utilisateur = "root";
            String motDePasse = "password";
            try {
                this.connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Recherche d'un utilisateur par identifiant
        public utilisateur_authentification.Utilisateur trouverParId(int id) {
            utilisateur_authentification.Utilisateur utilisateur = null;
            try {
                PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM utilisateur WHERE id_utilisateur=?");
                preparedStatement.setInt(1, id);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) {
                    utilisateur = new utilisateur_authentification.Utilisateur(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("mdp"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return utilisateur;
        }

        // Recherche d'un utilisateur par nom d'utilisateur et mot de passe
        public utilisateur_authentification.Utilisateur trouverParLoginMdp(String login, String mdp) {
            utilisateur_authentification.Utilisateur utilisateur = null;
            try {
                PreparedStatement preparedStatement = connexion.prepareStatement("SELECT * FROM utilisateur WHERE login=? AND mdp=?");
                preparedStatement.setString(1, login);
                preparedStatement.setString(2, mdp);
                ResultSet result = preparedStatement.executeQuery();
                if (result.next()) {
                    utilisateur = new utilisateur_authentification.Utilisateur(result.getInt("id_utilisateur"), result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("mdp"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return utilisateur;
        }
    public utilisateur_authentification.Utilisateur authentifier(String login, int mdp) throws DAOException {
        try {
            String sql = "SELECT * FROM utilisateur WHERE login=? AND mdp=?";
            PreparedStatement preparedStatement = this.connexion.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, String.valueOf(mdp));
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int idUtilisateur = resultSet.getInt("id_utilisateur");
                String nom = resultSet.getString("nom");
                String prenom = resultSet.getString("prenom");
                String loginBdd = resultSet.getString("login");
                String mdpBdd = resultSet.getString("mdp");
                utilisateur_authentification.Utilisateur utilisateur = new utilisateur_authentification.Utilisateur(idUtilisateur, nom, prenom, loginBdd, mdpBdd);
                return utilisateur;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DAOException("Erreur lors de l'authentification de l'utilisateur : " + e.getMessage(), e);
        }
    }

    public boolean create(utilisateur_authentification.Utilisateur utilisateur) {
        return false;
    }
}
