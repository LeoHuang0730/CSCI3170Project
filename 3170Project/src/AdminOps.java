import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminOps {

    public static void adminMenu(Scanner scanner, Connection conn) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("-----Operations for administrator menu-----");
            System.out.println("What kind of operation would you like to perform?");
            System.out.println("1. Create all tables");
            System.out.println("2. Delete all tables");
            System.out.println("3. Load from datafile");
            System.out.println("4. Show content of a table");
            System.out.println("5. Return to main menu");
            System.out.print("Enter Your Choice: ");

            int adminChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (adminChoice) {
                case 1:
                    System.out.println("Create all tables operation chosen.");
                    break;
                case 2:
                    System.out.println("Delete all tables operation chosen.");
                    break;
                case 3:
                    System.out.println("Load from datafile operation chosen.");
                    break;
                case 4:
                    System.out.println("Show content of a table operation chosen.");
                    break;
                case 5:
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        closeConnection(conn);
    }

    private static void closeConnection(Connection conn) {
        try {
            if (conn != null) conn.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            System.err.println("Failed to close the connection.");
            e.printStackTrace();
        }
    }
}