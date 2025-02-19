package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UneConnexion {
    public static void main(String[] args) {
        String strClassName = "com.mysql.jdbc.Driver";  
        String dbName = "progjava"; 
        String login = "root";
        String motdepasse = ""; 
        String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false&serverTimezone=UTC";

        try {
            Class.forName(strClassName);
            try (Connection conn = DriverManager.getConnection(strUrl, login, motdepasse)) {
                System.out.println("Connexion réussie !");
            }
        } catch (ClassNotFoundException e) {
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur de connexion !");
            e.printStackTrace();
        }
    }
}
