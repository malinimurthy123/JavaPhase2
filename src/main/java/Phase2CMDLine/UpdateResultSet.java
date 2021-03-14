package Phase2CMDLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateResultSet {

    String qry;
    Connection dbCon;
    Statement theStatement;

    public UpdateResultSet(){

        try {
//    		Define the URL to connect
            String urlToConnect = "jdbc:mysql://localhost:3306/simplilearn_phase2";

//    		Define the username for db to connect
            String dbUserName = "root";

//    		Define the password
            String dbUserPassword = "";

//    		Define the driver for the database
            String mySqlDriver = "com.mysql.cj.jdbc.Driver";


//        	Load the Driver
            Class.forName(mySqlDriver);

//			Try to establish the connection
            dbCon = DriverManager.getConnection(urlToConnect, dbUserName, dbUserPassword);

        } catch (ClassNotFoundException e) {
            System.out.println("Can't load the Driver : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Can't connect to DB : " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new UpdateResultSet().fetchAndUpdate();
    }

    void fetchAndUpdate() {
//	Write the query to fetch records from table:learners
        qry = "select * from learners";

//	Get a reference to the PreparedStatement
        try {
            PreparedStatement pstmt = dbCon.prepareStatement(qry, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

//		Execute the query
            ResultSet theResultSet = pstmt.executeQuery();

//		Traverse through the results
            while(theResultSet.next()) {
                if(theResultSet.getInt("learnerId") == 5) {
//				Update the current row
                    theResultSet.updateString("learnerName", theResultSet.getString("learnerName") + " Kumar");


//				Commit the changes
                    theResultSet.updateRow();

                    System.out.println("Name updated...");
                }
            }

        } catch (SQLException e) {
            System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
        }
    }

}