package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

	public static Connection connection;
		 // Method to establish and return a database connection
	public static Connection getConnection() {
		
		try {
			if(connection==null||connection.isClosed()) {
				   String url =  "jdbc:mysql://127.0.0.1:3306/drugstore";
				   String username = "root";  // Use root
			        String password = "";  // No password
				    connection = DriverManager.getConnection(url, username, password);  // No username, no password
	                System.out.println("Database Connected Successfully!");
		      }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database: " + e.getMessage());
        }
        return connection;
    }

    // Method to close the database connection
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Database Connection Closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
		
		
		
		

