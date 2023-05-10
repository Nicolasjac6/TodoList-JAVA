package utilisateur_authentification;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListeDAO {
    private Connection conn;

    public ListeDAO(Connection conn) {
        // Récupération des informations de connexion à la base de données depuis le fichier de configuration
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Connexion à la base de données
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
        }
    }

    public List<Liste> getListes() {
        List<Liste> listes = new ArrayList<>();
        String query = "SELECT * FROM liste";
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_liste");
                String nom = rs.getString("nom");
                String description = rs.getString("description");
                Liste liste = new Liste(id);
                listes.add(liste);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la récupération des listes : " + e.getMessage());
        }
        return listes;
    }

    public void ajouterListe(Liste liste) {
        String query = "INSERT INTO liste(nom, description) VALUES(?, ?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, liste.getNom());
            pstmt.setString(2, liste.getDescription());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout de la liste : " + e.getMessage());
        }
    }

    public void modifierListe(Liste liste) {
        String query = "UPDATE liste SET nom=?, description=? WHERE id_liste=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, liste.getNom());
            pstmt.setString(2, liste.getDescription());
            pstmt.setInt(3, liste.getIdListe());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la modification de la liste : " + e.getMessage());
        }
    }

    public void supprimerListe(Liste liste) {
        String query = "DELETE FROM liste WHERE id_liste=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, liste.getIdListe());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la suppression de la liste : " + e.getMessage());
        }
    }

    public void fermerConnexion() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println("Erreur lors de la fermeture de la connexion à la base de données : " + e.getMessage());
        }
    }

    public void create(Liste nouvelleListe) {
    }

    public List<Liste> findByUtilisateur(Utilisateur utilisateur) {
        return null;
    }
}
