import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:oracle:thin:@db18.cse.cuhk.edu.hk:1521/oradb.cse.cuhk.edu.hk"; // Replace with your Oracle DB URL
        String username = "h046"; // Your username
        String password = "FitOfEup"; // Your password

        Connection conn = null;
        Statement stmt = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("Oracle JDBC Driver Loaded Successfully!");

            // Establish connection
            conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the Oracle Database Successfully!");

            // Create a Statement object
            stmt = conn.createStatement();

            // Step 1: Create a Table
            String createTableSQL = "CREATE TABLE test_table (" +
                    "id NUMBER PRIMARY KEY, " +
                    "name VARCHAR2(50), " +
                    "created_at DATE)";
            stmt.executeUpdate(createTableSQL);
            System.out.println("Table 'test_table' created successfully!");

            // Step 2: Insert Data into the Table
            String insertDataSQL = "INSERT INTO test_table (id, name, created_at) " +
                    "VALUES (1, 'Test User', SYSDATE)";
            stmt.executeUpdate(insertDataSQL);
            System.out.println("Data inserted into 'test_table' successfully!");

        } catch (ClassNotFoundException e) {
            System.err.println("Oracle JDBC Driver not found! Add ojdbc10.jar to your classpath.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Database operation failed! Check output for more details.");
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Connection closed.");
            } catch (SQLException e) {
                System.err.println("Failed to close the connection.");
                e.printStackTrace();
            }
        }

        // Start user interface
        startUserInterface();
    }

    private static void startUserInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean exitProgram = false;

        while (!exitProgram) {
            // Main Menu
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
                    handleAdministratorMenu(scanner);
                    break;
                case 2:
                    handleSalespersonMenu(scanner);
                    break;
                case 3:
                    handleManagerMenu(scanner);
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

    private static void handleAdministratorMenu(Scanner scanner) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            // Administrator Menu
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
    }

    private static void handleSalespersonMenu(Scanner scanner) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            // Salesperson Menu
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
                    handleSearchForParts(scanner);
                    break;
                case 2:
                    handleSellPart(scanner);
                    break;
                case 3:
                    returnToMainMenu = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleManagerMenu(Scanner scanner) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            // Manager Menu
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
                    System.out.println("Choose ordering:");
                    System.out.println("1. By ascending order");
                    System.out.println("2. By descending order");
                    System.out.print("Input the list order: ");
                    int listOrder = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character
                    System.out.println("List operation chosen with order: " + (listOrder == 1 ? "Ascending" : "Descending"));
                    break;

                case 2:
                    System.out.print("Type in the lower bound for years of experience: ");
                    int lowerBound = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.print("Type in the upper bound for years of experience: ");
                    int upperBound = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Count operation chosen for range: " + lowerBound + " to " + upperBound + " years.");
                    break;

                case 3:
                    System.out.println("Show the total sales value of each manufacturer operation chosen.");
                    break;

                case 4:
                    System.out.print("Type in the number of parts: ");
                    int numberOfParts = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    System.out.println("Show the " + numberOfParts + " most popular parts operation chosen.");
                    break;

                case 5:
                    returnToMainMenu = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleSearchForParts(Scanner scanner) {
        // Search for parts
        System.out.println("Choose the Search criterion:");
        System.out.println("1. Part Name");
        System.out.println("2. Manufacturer Name");
        System.out.print("Input the Search Criterion: ");

        int searchCriterion = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (searchCriterion == 1 || searchCriterion == 2) {
            System.out.print("Type in the Search Keyword: ");
            String keyword = scanner.nextLine();

            System.out.println("Choose ordering:");
            System.out.println("1. By price, ascending order");
            System.out.println("2. By price, descending order");
            System.out.print("Choose the search criterion: ");

            int orderingChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (orderingChoice == 1 || orderingChoice == 2) {
                System.out.println("Search operation performed with the given criteria and ordering.");
            } else {
                System.out.println("Invalid ordering choice.");
            }
        } else {
            System.out.println("Invalid search criterion.");
        }
    }

    private static void handleSellPart(Scanner scanner) {
        // Sell a part
        System.out.print("Enter the Part ID: ");
        String partId = scanner.nextLine();

        System.out.print("Enter the Salesperson ID: ");
        String salespersonId = scanner.nextLine();

        System.out.println("Sell operation performed for Part ID: " + partId + " by Salesperson ID: " + salespersonId);
    }
}