import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AdminOps {

    private static final String BASE_FOLDER_PATH = "C:\\Users\\user\\Desktop\\3170Project\\";

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
                    executeSQLFile(conn, BASE_FOLDER_PATH + "src\\AdminCreate.sql");
                    break;
                case 2:
                    executeSQLFile(conn, BASE_FOLDER_PATH + "src\\AdminDelete.sql");
                    break;
                case 3:
                    System.out.print("Enter the name of the folder containing the data files: ");
                    String dataFolder = scanner.nextLine();
                    loadData(conn, BASE_FOLDER_PATH + dataFolder);
                    break;
                case 4:
                    showTableContent(scanner, conn);
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

    private static void executeSQLFile(Connection conn, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             java.sql.Statement stmt = conn.createStatement()) {

            StringBuilder sqlBuilder = new StringBuilder();
            String line;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("--")) { // Ignore comments and empty lines
                    sqlBuilder.append(line).append(" ");
                    if (line.endsWith(";")) { // Execute when a full SQL statement is found
                        String sql = sqlBuilder.toString().replace(";", ""); // Remove the semicolon
                        stmt.execute(sql.trim()); // Execute the SQL statement
                        sqlBuilder.setLength(0); // Reset the builder
                    }
                }
            }

            System.out.println("SQL file '" + filePath + "' executed successfully.");

        } catch (IOException e) {
            System.err.println("Error reading SQL file: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error executing SQL file: " + e.getMessage());
        }
    }

    private static void loadData(Connection conn, String folderPath) {
        String[] fileNames = {"category.txt", "manufacturer.txt", "part.txt", "salesperson.txt", "transaction.txt"};

        try {
            for (String fileName : fileNames) {
                String filePath = folderPath + "\\" + fileName;
                System.out.println("Loading data from file: " + filePath);

                switch (fileName) {
                    case "category.txt":
                        loadCategoryData(filePath, conn);
                        break;
                    case "manufacturer.txt":
                        loadManufacturerData(filePath, conn);
                        break;
                    case "part.txt":
                        loadPartData(filePath, conn);
                        break;
                    case "salesperson.txt":
                        loadSalespersonData(filePath, conn);
                        break;
                    case "transaction.txt":
                        loadTransactionData(filePath, conn);
                        break;
                    default:
                        System.out.println("Unknown file: " + fileName);
                }
            }
            System.out.println("All data files loaded successfully.");
        } catch (IOException | SQLException e) {
            System.err.println("Error loading data: " + e.getMessage());
        }
    }

    private static void loadCategoryData(String filePath, Connection conn) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO category (cID, cName) VALUES (?, ?)")) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                pstmt.setInt(1, Integer.parseInt(data[0])); // cID
                pstmt.setString(2, data[1]); // cName
                pstmt.executeUpdate();
            }
        }
    }

    private static void loadManufacturerData(String filePath, Connection conn) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO manufacturer (mID, mName, mAddress, mPhoneNumber) VALUES (?, ?, ?, ?)")) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                pstmt.setInt(1, Integer.parseInt(data[0])); // mID
                pstmt.setString(2, data[1]); // mName
                pstmt.setString(3, data[2]); // mAddress
                pstmt.setInt(4, Integer.parseInt(data[3])); // mPhoneNumber
                pstmt.executeUpdate();
            }
        }
    }

    private static void loadPartData(String filePath, Connection conn) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO part (pID, pName, pPrice, mID, cID, pWarrantyPeriod, pAvailableQuantity) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                pstmt.setInt(1, Integer.parseInt(data[0])); // pID
                pstmt.setString(2, data[1]); // pName
                pstmt.setInt(3, Integer.parseInt(data[2])); // pPrice
                pstmt.setInt(4, Integer.parseInt(data[3])); // mID
                pstmt.setInt(5, Integer.parseInt(data[4])); // cID
                pstmt.setInt(6, Integer.parseInt(data[5])); // pWarrantyPeriod
                pstmt.setInt(7, Integer.parseInt(data[6])); // pAvailableQuantity
                pstmt.executeUpdate();
            }
        }
    }

    private static void loadSalespersonData(String filePath, Connection conn) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO salesperson (sID, sName, sAddress, sPhoneNumber, sExperience) VALUES (?, ?, ?, ?, ?)")) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                pstmt.setInt(1, Integer.parseInt(data[0])); // sID
                pstmt.setString(2, data[1]); // sName
                pstmt.setString(3, data[2]); // sAddress
                pstmt.setInt(4, Integer.parseInt(data[3])); // sPhoneNumber
                pstmt.setInt(5, Integer.parseInt(data[4])); // sExperience
                pstmt.executeUpdate();
            }
        }
    }

    private static void loadTransactionData(String filePath, Connection conn) throws IOException, SQLException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath));
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO transaction (tID, pID, sID, tDate) VALUES (?, ?, ?, TO_DATE(?, 'DD/MM/YYYY'))")) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split("\t");
                pstmt.setInt(1, Integer.parseInt(data[0])); // tID
                pstmt.setInt(2, Integer.parseInt(data[1])); // pID
                pstmt.setInt(3, Integer.parseInt(data[2])); // sID
                pstmt.setString(4, data[3]); // tDate
                pstmt.executeUpdate();
            }
        }
    }

    private static void showTableContent(Scanner scanner, Connection conn) {
        System.out.print("Enter the name of the table to display its content: ");
        String tableName = scanner.nextLine();

        String query = "SELECT * FROM " + tableName;

        try (java.sql.Statement stmt = conn.createStatement();
             java.sql.ResultSet rs = stmt.executeQuery(query)) {

            int columnCount = rs.getMetaData().getColumnCount();

            // Print column headers with "|"
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("| " + rs.getMetaData().getColumnName(i) + " ");
            }
            System.out.println("|");

            // Print a separator line
            for (int i = 1; i <= columnCount; i++) {
                System.out.print("|" + "-".repeat(rs.getMetaData().getColumnName(i).length() + 2));
            }
            System.out.println("|");

            // Print rows of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.print("| " + rs.getString(i) + " ");
                }
                System.out.println("|");
            }
        } catch (SQLException e) {
            System.err.println("Error fetching data from table: " + e.getMessage());
        }
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