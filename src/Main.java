import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;

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
  }
}