package dbtest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoredProcedureTest {
	
	 private Connection connection;

	    @BeforeClass
	    public void setUp() {
	        connection = DBConnection.getConnection();  // Establish DB connection
	    }

	    	    @Test
	    	    public void testDeliveryAreaInsertion() {
	    	        try {
	    	            // Prepare and execute the stored procedure
	    	            CallableStatement callableStatement = connection.prepareCall("{CALL insert_delivery_area(?, ?, ?, ?, ?, ?, ?, ?)}");
	    	            
	    	            // Set input parameters for the stored procedure
	    	            callableStatement.setString(1, "Test Location");   // Location
	    	            callableStatement.setInt(2, 123456);               // Pin code
	    	            callableStatement.setString(3, "Test Country");    // Country
	    	            callableStatement.setString(4, "Test State");      // State
	    	            callableStatement.setString(5, "Test District");   // District
	    	            callableStatement.setString(6, "Test Remarks");    // Remarks
	    	            callableStatement.setString(7, "active");         // Status
	    	            callableStatement.setInt(8, 5678);                    // Admin ID 

	    	            // Execute the stored procedure
	    	            callableStatement.execute();

	    	            // Fetch the last inserted ID using LAST_INSERT_ID()
	    	            CallableStatement lastIdStmt = connection.prepareCall("SELECT LAST_INSERT_ID();");
	    	            ResultSet rs = lastIdStmt.executeQuery();
	    	            
	    	            int lastInsertedId = 0;
	    	            if (rs.next()) {
	    	                lastInsertedId = rs.getInt(1);
	    	                System.out.println("Last Inserted ID: " + lastInsertedId);
	    	            }
	    	            
	    	            // Validate if the record is inserted into the delivery_areas table
	    	            String checkQuery = "SELECT * FROM delivery_areas WHERE delarea_id = " + lastInsertedId;
	    	            ResultSet checkResult = connection.createStatement().executeQuery(checkQuery);

	    	            // Assert that the new record exists in the table
	    	            if (checkResult.next()) {
	    	                String location = checkResult.getString("delarea_location");
	    	                int pincode = checkResult.getInt("delarea_pincode");

	    	                // Assertions (modify based on expected data)
	    	                Assert.assertEquals(location, "Test Location", "Location mismatch");
	    	                Assert.assertEquals(pincode, 123456, "Pincode mismatch");
	    	            } else {
	    	                Assert.fail("Record not found in the delivery_areas table.");
	    	            }
	    	            
	    	            rs.close();
	    	            lastIdStmt.close();
	    	            callableStatement.close();
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	            Assert.fail("Stored procedure execution failed!");
	    	        }
	    	    }

	    	    @AfterClass
	    	    public void tearDown() {
	    	        DBConnection.closeConnection();  // Close DB connection
	    	    }
	    	}