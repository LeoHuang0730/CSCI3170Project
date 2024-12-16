import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class SalesOps {

    private static final String SQL_FOLDER_PATH = "C:\\Users\\user\\Desktop\\3170Project\\src\\";

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
                    searchForParts(scanner, conn);
                    break;
                case 2:
                    sellPart(scanner, conn);
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

    private static void searchForParts(Scanner scanner, Connection conn) {
        System.out.println("Choose the Search Criterion:");
        System.out.println("1. Part Name");
        System.out.println("2. Manufacturer Name");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String sqlFile = (searchChoice == 1) ? "SearchPartName.sql" : "SearchManufacturerName.sql";

        System.out.print("Type in the Search Keyword: ");
        String keyword = scanner.nextLine();

        System.out.println("Choose Ordering:");
        System.out.println("1. By price, ascending order");
        System.out.println("2. By price, descending order");
        int orderChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String orderByClause = (orderChoice == 1) ? "ASC" : "DESC";

        try {
            // Read the base query from the SQL file without an ORDER BY clause
            String baseQuery = readSQLFile(SQL_FOLDER_PATH + sqlFile);

            // Dynamically append the ORDER BY clause
            String query = baseQuery + " ORDER BY p.pPrice " + orderByClause;

            // Log SQL file execution
            System.out.println("Executing SQL from file: " + sqlFile);

            // Prepare and execute the query
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "%" + keyword + "%"); // Add wildcards for partial matching
                try (ResultSet rs = pstmt.executeQuery()) {
                    printResultSet(rs);
                }
            }
        } catch (IOException | SQLException e) {
            System.err.println("Error performing search: " + e.getMessage());
        }
    }

    private static void sellPart(Scanner scanner, Connection conn) {
        System.out.print("Enter The Part ID: ");
        int partID = scanner.nextInt();
        System.out.print("Enter The Salesperson ID: ");
        int salespersonID = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        try {
            // Check availability
            String checkQuery = readSQLFile(SQL_FOLDER_PATH + "CheckPartAvailability.sql");
            System.out.println("Executing SQL from file: CheckPartAvailability.sql");
            try (PreparedStatement checkStmt = conn.prepareStatement(checkQuery)) {
                checkStmt.setInt(1, partID);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next()) {
                        String partName = rs.getString("pName");
                        int availableQuantity = rs.getInt("pAvailableQuantity");

                        if (availableQuantity > 0) {
                            // Perform the transaction
                            String updateQuery = readSQLFile(SQL_FOLDER_PATH + "SellPart.sql");
                            System.out.println("Executing SQL from file: SellPart.sql");
                            try (PreparedStatement updateStmt = conn.prepareStatement(updateQuery)) {
                                updateStmt.setInt(1, partID);
                                updateStmt.executeUpdate();
                                System.out.println("Product: " + partName + " (id: " + partID + ") Remaining Quantity: " + (availableQuantity - 1));
                            }
                        } else {
                            System.out.println("Error: Part is out of stock.");
                        }
                    } else {
                        System.out.println("Error: Part ID not found.");
                    }
                }
            }
        } catch (IOException | SQLException e) {
            System.err.println("Error performing transaction: " + e.getMessage());
        }
    }

    private static void printResultSet(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        // Print column headers
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("| " + metaData.getColumnName(i).toUpperCase() + " ");
        }
        System.out.println("|");

        // Print a separator line
        for (int i = 1; i <= columnCount; i++) {
            System.out.print("|" + "-".repeat(metaData.getColumnName(i).length() + 2));
        }
        System.out.println("|");

        // Print rows
        while (rs.next()) {
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("| " + rs.getString(i) + " ");
            }
            System.out.println("|");
        }
        System.out.println("End of Query");
    }

    private static String readSQLFile(String filePath) throws IOException {
        StringBuilder sqlBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                sqlBuilder.append(line).append("\n");
            }
        }
        return sqlBuilder.toString().trim();
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