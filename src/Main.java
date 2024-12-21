import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        startUserInterface();
    }

    private static void startUserInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("-----Main Menu-----");
            System.out.println("What kind of operation would you like to perform?");
            System.out.println("1. Operations for administrator");
            System.out.println("2. Operations for salesperson");
            System.out.println("3. Operations for manager");
            System.out.println("4. Exit this program");
            System.out.print("Enter Your Choice: ");

            int mainChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (mainChoice) {
                case 1:
                    AdminOps.adminMenu(scanner, establishConnection());
                    break;
                case 2:
                    SalesOps.salesMenu(scanner, establishConnection());
                    break;
                case 3:
                    ManagerOps.managerMenu(scanner, establishConnection());
                    break;
                case 4:
                    exitProgram = true;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static Connection establishConnection() {
        String url = "jdbc:oracle:thin:@db18.cse.cuhk.edu.hk:1521/oradb.cse.cuhk.edu.hk";
        String username = "h046"; // Replace with your Oracle DB username
        String password = "FitOfEup"; // Replace with your Oracle DB password

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Loaded Successfully!");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the Oracle Database Successfully!");
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC Driver not found! Add ojdbc10.jar to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database operation failed! Check output for more details.");
            e.printStackTrace();
        }
        return null;
    }
}