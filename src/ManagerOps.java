import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class ManagerOps {

    public static void managerMenu(Scanner scanner, Connection conn) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("-----Operations for manager menu-----");
            System.out.println("What kinds of operation would you like to perform?");
            System.out.println("1. List all salespersons");
            System.out.println("2. Count the no. of sales record of each salesperson under a specific range on years of experience");
            System.out.println("3. Show the total sales value of each manufacturer");
            System.out.println("4. Show the N most popular part");
            System.out.println("5. Return to the main menu");
            System.out.print("Enter Your Choice: ");

            int managerChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (managerChoice) {
                case 1:
                    System.out.println("List all salespersons operation chosen.");
                    break;
                case 2:
                    System.out.println("Count sales records operation chosen.");
                    break;
                case 3:
                    System.out.println("Show total sales value of each manufacturer operation chosen.");
                    break;
                case 4:
                    System.out.println("Show most popular parts operation chosen.");
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