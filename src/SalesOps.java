import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class SalesOps {

    public static void salesMenu(Scanner scanner, Connection conn) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("-----Operations for salesperson menu-----");
            System.out.println("What kind of operation would you like to perform?");
            System.out.println("1. Search for parts");
            System.out.println("2. Sell a part");
            System.out.println("3. Return to main menu");
            System.out.print("Enter Your Choice: ");

            int salespersonChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (salespersonChoice) {
                case 1:
                    System.out.println("Search for parts operation chosen.");
                    break;
                case 2:
                    System.out.println("Sell a part operation chosen.");
                    break;
                case 3:
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