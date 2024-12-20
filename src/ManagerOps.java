import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class ManagerOps {
    private static final String SQL_FOLDER_PATH = "./src/";

    public static void managerMenu(Scanner scanner, Connection conn) {
        boolean returnToMainMenu = false;

        while (!returnToMainMenu) {
            System.out.println("-----Operations for Manager Menu-----");
            System.out.println("What kinds of operation would you like to perform?");
            System.out.println("1. List all salespersons");
            System.out.println("2. Count the no. of sales record of each salesperson under a specific range on years of experience");
            System.out.println("3. Show the total sales value of each manufacturer");
            System.out.println("4. Show the N most popular parts");
            System.out.println("5. Return to the main menu");
            System.out.print("Enter Your Choice: ");

            int managerChoice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (managerChoice) {
                case 1:
                    listAllSalespersons(scanner, conn);
                    break;
                case 2:
                    countSalesRecords(scanner, conn);
                    break;
                case 3:
                    showTotalSalesByManufacturer(conn);
                    break;
                case 4:
                    nMostPopularParts(scanner, conn);
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

    private static void listAllSalespersons(Scanner scanner, Connection conn) {
        System.out.println("Choose Ordering:");
        System.out.println("1. By ascending order");
        System.out.println("2. By descending order");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character
        String order = (choice == 1) ? "ASC" : "DESC";

        String query = readSQLFromFile(SQL_FOLDER_PATH + "listAllSalespersons.sql");
        query = query.replace(":order", order);

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("| ID | Name             | Mobile Phone | Years of Experience |");
            System.out.println("|----|------------------|--------------|---------------------|");

            while (rs.next()) {
                System.out.printf("| %-2d | %-16s | %-12s | %-19d |\n",
                        rs.getInt("sID"),
                        rs.getString("sName"),
                        rs.getString("sPhoneNumber"),
                        rs.getInt("sExperience"));
            }
            System.out.println("End of Query");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void countSalesRecords(Scanner scanner, Connection conn) {
        System.out.print("Type in the lower bound for years of experience: ");
        int lowerBound = scanner.nextInt();
        System.out.print("Type in the upper bound for years of experience: ");
        int upperBound = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String query = readSQLFromFile(SQL_FOLDER_PATH + "countSalesRecords.sql");

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, lowerBound);
            pstmt.setInt(2, upperBound);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("| ID | Name             | Years of Experience | Number of Transactions |");
                System.out.println("|----|------------------|---------------------|-------------------------|");

                while (rs.next()) {
                    System.out.printf("| %-2d | %-16s | %-19d | %-23d |\n",
                            rs.getInt("sID"),
                            rs.getString("sName"),
                            rs.getInt("sExperience"),
                            rs.getInt("transaction_count"));
                }
                System.out.println("End of Query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void showTotalSalesByManufacturer(Connection conn) {
        String query = readSQLFromFile(SQL_FOLDER_PATH + "showTotalSalesByManufacturer.sql");

        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("| ManufacturerID | Manufacturer Name | Total Sales Value |");
            System.out.println("|----------------|-------------------|-------------------|");

            while (rs.next()) {
                System.out.printf("| %-14d | %-17s | %-17.2f |\n",
                        rs.getInt("mID"),
                        rs.getString("mName"),
                        rs.getDouble("total_sales_value"));
            }
            System.out.println("End of Query");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void nMostPopularParts(Scanner scanner, Connection conn) {
        System.out.print("Type in the number of parts: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        if (n <= 0) {
            System.out.println("Invalid number. Must be greater than 0.");
            return;
        }

        String query = readSQLFromFile(SQL_FOLDER_PATH + "nMostPopularParts.sql");

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, n);

            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("| Part ID | Part Name         | No. of Transactions |");
                System.out.println("|---------|-------------------|---------------------|");

                while (rs.next()) {
                    System.out.printf("| %-7d | %-17s | %-19d |\n",
                            rs.getInt("pID"),
                            rs.getString("pName"),
                            rs.getInt("transaction_count"));
                }
                System.out.println("End of Query");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String readSQLFromFile(String filePath) {
        StringBuilder query = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                query.append(line).append("\n");
            }
        } catch (IOException e) {
            System.err.println("Failed to read SQL file: " + filePath);
            e.printStackTrace();
        }
        return query.toString();
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