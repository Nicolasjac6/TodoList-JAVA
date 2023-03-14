import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TacheDAO {

    private Connection connection;

    public TacheDAO(Connection connection) {
        this.connection = connection;
    }

    public boolean create(Tache tache) throws SQLException {
        String query = "INSERT INTO tache (nom, description, est_realise, id_liste, id_type) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, tache.getNom());
        ps.setString(2, tache.getDescription());
        ps.setBoolean(3, tache.isEstRealise());
        ps.setInt(4, tache.getListe().getIdListe());
        ps.setInt(5, tache.getType().getidType());
        int result = ps.executeUpdate();
        return result > 0;
    }

    public boolean update(Tache tache) throws SQLException {
        String query = "UPDATE tache SET nom = ?, description = ?, est_realise = ?, id_liste = ?, id_type = ? WHERE id_tache = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, tache.getNom());
        ps.setString(2, tache.getDescription());
        ps.setBoolean(3, tache.isEstRealise());
        ps.setInt(4, tache.getListe().getIdListe());
        ps.setInt(5, tache.getType().getidType());
        ps.setInt(6, tache.getIdTache());
        int result = ps.executeUpdate();
        return result > 0;
    }

    public boolean delete(Tache tache) throws SQLException {
        String query = "DELETE FROM tache WHERE id_tache = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, tache.getIdTache());
        int result = ps.executeUpdate();
        return result > 0;
    }

    public List<Tache> getAll() throws SQLException {
        String query = "SELECT * FROM tache";
        PreparedStatement ps = connection.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Tache> taches = new ArrayList<>();
        while (rs.next()) {
            int idTache = rs.getInt("id_tache");
            String nom = rs.getString("nom");
            String description = rs.getString("description");
            boolean estRealise = rs.getBoolean("est_realise");
            int idListe = rs.getInt("id_liste");
            int idType = rs.getInt("id_type");
            Tache tache = new Tache(idTache, nom, description, estRealise, new Liste(idListe), new Type(idType));
            taches.add(tache);
        }
        return taches;
    }

    public List<Tache> getByListe(Liste liste) throws SQLException {
        String query = "SELECT * FROM tache WHERE id_liste = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, liste.getIdListe());
        ResultSet rs = ps.executeQuery();
        List<Tache> taches = new ArrayList<>();
        while (rs.next()) {
            int idTache = rs.getInt("id_tache");
            String nom = rs.getString("nom");
            String description = rs.getString("description");
            boolean estRealise = rs.getBoolean("est_realise");
            Tache tache = new Tache(idTache, nom, description, estRealise, liste, new Type(rs.getInt("id_type")));
            taches.add(tache);
        }
        return taches;
    }
}
