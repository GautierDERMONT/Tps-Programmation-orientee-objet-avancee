package JDBC;
import java.sql.*;
import java.util.Scanner;

public class UpdateStatus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            String strClassName = "com.mysql.jdbc.Driver"; 
            String dbName = "progjava"; 
            String login = "root"; 
            String motdepasse = ""; 
            String strUrl = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";

            Class.forName(strClassName);
            Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);

            System.out.print("Entrez l'ID de l'utilisateur dont vous voulez modifier le statut : ");
            int idToUpdate = scanner.nextInt();
            scanner.nextLine();  
            
            System.out.print("Entrez le nouveau statut pour cet utilisateur : ");
            String newStatus = scanner.nextLine();

            
            String sql = "UPDATE Acces SET statut = ? WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, newStatus);  
            preparedStatement.setInt(2, idToUpdate);  
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Le statut de l'utilisateur avec ID " + idToUpdate + " a été mis à jour avec succès !");
            } else {
                System.out.println("Aucun utilisateur trouvé avec cet ID !");
            }

            preparedStatement.close();
            conn.close();
            scanner.close();

        } catch (ClassNotFoundException e) {  
            System.err.println("Driver non chargé !");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Erreur SQL !");
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Erreur inattendue !");
            e.printStackTrace();
        }
    }
}
