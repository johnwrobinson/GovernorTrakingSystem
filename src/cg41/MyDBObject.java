package cg41;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class was given to me by my teacher.
 * @author cselby
 *
 * This object is my custom database object.  I will use it to access the
 * MySQL server where the database resides.
 */
public class MyDBObject {

    private Connection conn = null;
    public Statement stmt = null;
    public int ErrorCode = 0;           // Default place for caller to look for error
    public String sqlString;            // For executing request
    public ResultSet rs = null;         // For returning records
    public int NumberOfRecords = 0;     // For returning number of records found
    public int LastInsertedKey = 0;     // For insert requests only, the key generated

    public int deleteRecord() {
        ErrorCode = 0;                  // No error so far
        try {
            if (rs != null) {
                rs.close();            // Clean up before starting again
                rs = null;
            }
            if (stmt != null) {
                stmt.close();          // Clean up
                stmt = null;
            }
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.execute(sqlString);
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();

            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return (ErrorCode);
    }

    public int updateRecord() {
        ErrorCode = 0;                  // No error so far
        try {
            if (rs != null) {
                rs.close();            // Clean up before starting again
                rs = null;
            }
            if (stmt != null) {
                stmt.close();          // Clean up
                stmt = null;
            }
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.execute(sqlString);
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();

            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return (ErrorCode);
    }

    public int insertRecord() {
        // You can check LastInsertedKey after this call to find the
        // autonumber field that was added to the table
        ErrorCode = 0;                  // No error so far
        try {
            if (rs != null) {
                rs.close();            // Clean up before starting again
                rs = null;
            }
            if (stmt != null) {
                stmt.close();          // Clean up
                stmt = null;
            }
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            stmt.execute(sqlString, Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                LastInsertedKey = rs.getInt(1);
            }
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();

            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return (ErrorCode);
    }

    public int getRecordSetBySelect() {
        ErrorCode = 0;                  // No error so far
        try {
            if (rs != null) {
                rs.close();            // Clean up before starting again
                rs = null;
            }
            if (stmt != null) {
                stmt.close();          // Clean up
                stmt = null;
            }
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sqlString);
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();

            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return (ErrorCode);
    }

    public int getCountBySelect() {
        /* This function sets the RecordCount variable in the object in
         * preparation for a later call.  Use this when you want to know
         * how many objects your next call is going to return.
         * This is useful for preparing arrays to receive the data
         * */
        ErrorCode = 0;                  // No error so far
        try {
            if (rs != null) {
                rs.close();            // Clean up before starting again
                rs = null;
            }
            if (stmt != null) {
                stmt.close();          // Clean up
                stmt = null;
            }
            stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sqlString);
            rs.first();                        // Point to first record
            NumberOfRecords = rs.getInt(1);    // Number of records possible
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();

            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
        return (ErrorCode);
    }
    // My customised constructor, which will make a database connection

    public MyDBObject() {
        ErrorCode = 0;                  // Start with no error state
        try {
            conn = DriverManager.getConnection(
                    // This is for the local server
                    //"jdbc:mysql://localhost/cg4", "root", "password");

                    // This is for the server at school
                    "jdbc:mysql://192.168.0.53:3306/Robinson_John",
                    "Robinson_John", "209160");
        } catch (SQLException ex) {
            // Show errors in console
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            ErrorCode = ex.getErrorCode();     // For whomever called us
            if (ErrorCode == 0) {
                ErrorCode = 1;
            }
            UserMessageBox MyMessage = new UserMessageBox();
            MyMessage.setMessage("SQLException: " + ex.getMessage());
            MyMessage.setVisible(true);
        }
    }
}
