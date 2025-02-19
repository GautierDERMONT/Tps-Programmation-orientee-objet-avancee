package JDBC;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            DAOAcces daoAcces = new DAOAcces();

            System.out.println("Liste des accès existants :");
            List<Acces> accesList = daoAcces.listerDAO();
            for (Acces a : accesList) {
                System.out.println(a);
            }

            System.out.println("\nAjout d'un nouvel accès :");
            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Prénom: ");
            String prenom = scanner.nextLine();
            System.out.print("Login: ");
            String login = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();
            System.out.print("Statut: ");
            String statut = scanner.nextLine();
            System.out.print("Âge: ");
            int age = scanner.nextInt();

            Acces newAcces = new Acces(id, prenom, login, password, statut, age);
            daoAcces.ajouterDAO(newAcces);

            System.out.println("\nListe des accès après ajout :");
            accesList = daoAcces.listerDAO();
            for (Acces a : accesList) {
                System.out.println(a);
            }

            System.out.println("\nSuppression d'un accès :");
            System.out.print("Entrez l'ID de l'accès à supprimer : ");
            int idToDelete = scanner.nextInt();
            Acces accesToDelete = new Acces(idToDelete, "", "", "", "", 0);
            daoAcces.supprimerDAO(accesToDelete);

            System.out.println("\nListe des accès après suppression :");
            accesList = daoAcces.listerDAO();
            for (Acces a : accesList) {
                System.out.println(a);
            }

            daoAcces.fermer();
            scanner.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
