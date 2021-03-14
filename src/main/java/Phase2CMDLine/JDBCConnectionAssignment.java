package Phase2CMDLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCConnectionAssignment {
    String qry;
    Connection dbCon;
    Statement theStatement;

    public void UsingPreparedStatement(){

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
        Scanner theScanner = new Scanner(System.in);

//		System.out.println("Please enter name and address");

//		new UsingPreparedStatement().addNewLearner(theScanner.nextLine(), theScanner.nextLine());

        System.out.println("Enter id : ");

        int id = theScanner.nextInt();

        new JDBCConnectionAssignment().getLearnerDetailsById(id);
    }
    //	Insert a new record in the table:learners using PreparedStatement
    void addNewLearner(String learnerName, String learnerAddress) {
//		Write the query to insert
        qry = "insert into learners(learnerName, learnerAddress) values(?, ?)";

        try {
//			Get a reference to the PreparedStatement
            PreparedStatement thePreparedStatement = dbCon.prepareStatement(qry);

//			Set the values for ?
            thePreparedStatement.setString(1, learnerName);
            thePreparedStatement.setString(2, learnerAddress);

//			Execute the query
            if(thePreparedStatement.executeUpdate() > 0)
                System.out.println("Record added...");

        } catch (SQLException e) {
            System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
        }
    }

    //Fetch all details of a learner by id from table:learners
    void getLearnerDetailsById(int id) {
//		Write the query
        qry = "select * from learners where learnerId = ?";


        try {
//			Get a reference to the PreparedStatement
            PreparedStatement thePreparedStatement = dbCon.prepareStatement(qry);

//			Set the value for ?
            thePreparedStatement.setInt(1, id);

//			Execute the query
            ResultSet theResultSet = thePreparedStatement.executeQuery();

//			Traverse through the results
            while(theResultSet.next()) {
                System.out.print("Name : " + theResultSet.getString("learnerName"));
                System.out.println(", Address : " + theResultSet.getString("learnerAddress"));
            }

        } catch (SQLException e) {
            System.out.println("Can't get a reference to the PreparedStatement : " + e.getMessage());
        }
    }

}