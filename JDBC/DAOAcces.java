package JDBC;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOAcces {
    private Connection conn;

    public DAOAcces() throws ClassNotFoundException, SQLException {
        String strClassName = "com.mysql.jdbc.Driver";
        String dbName = "progjava"; 
        String login = "root"; 
        String motdepasse = ""; 
        String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
        
        Class.forName(strClassName);
        conn = DriverManager.getConnection(strUrl, login, motdepasse);
    }

    public void fermer() throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    public List<Acces> listerDAO() throws SQLException {
        List<Acces> accesList = new ArrayList<>();
        String query = "SELECT * FROM Acces";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            Acces acces = new Acces(
                rs.getInt("id"),
                rs.getString("prenom"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("statut"),
                rs.getInt("age")
            );
            accesList.add(acces);
        }

        return accesList;
    }

    public void ajouterDAO(Acces a) throws SQLException {
        String query = "INSERT INTO Acces (id, prenom, login, password, statut, age) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, a.getId());
        pst.setString(2, a.getPrenom());
        pst.setString(3, a.getLogin());
        pst.setString(4, a.getPassword());
        pst.setString(5, a.getStatut());
        pst.setInt(6, a.getAge());

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Acces ajouté avec succès !");
        } else {
            System.out.println("Échec de l'ajout.");
        }
    }

    public void supprimerDAO(Acces a) throws SQLException {
        String query = "DELETE FROM Acces WHERE id = ?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, a.getId());

        int rowsAffected = pst.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Acces supprimé avec succès !");
        } else {
            System.out.println("Aucun accès trouvé avec cet ID.");
        }
    }
}
