package JDBC;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

    public static void main(String[] args) {

        try { 
            String strClassName = "com.mysql.jdbc.Driver"; 
            String dbName = "progjava"; 
            String login = "root"; 
            String motdepasse = ""; 
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
            Statement stAddUser = conn.createStatement();  

            int rowsAffected = stAddUser.executeUpdate("insert into Acces values (5, 'Tom', 'tomahawk', 'indien', 'Etudiant', 22)");

          
            if (rowsAffected > 0) {
                System.out.println("L'utilisateur a été inséré avec succès !");
            } else {
                System.out.println("Aucune ligne insérée.");
            }
            conn.close();

        } catch (ClassNotFoundException e) {  
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Autre erreur !");
            e.printStackTrace();
        }
    }
}
