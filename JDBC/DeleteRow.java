package JDBC;
import java.sql.*;
import java.util.Scanner;

public class DeleteRow {

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

            System.out.print("Entrez l'ID de la ligne à supprimer : ");
            int idToDelete = scanner.nextInt();

            String sql = "DELETE FROM Acces WHERE id = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, idToDelete);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Ligne supprimée avec succès !");
            } else {
                System.out.println("Aucune ligne trouvée avec cet ID !");
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

