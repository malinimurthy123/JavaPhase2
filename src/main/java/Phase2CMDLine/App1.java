package Phase2CMDLine;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class App1
{
    String qry;
    Connection dbCon;
    Statement theStatement;

    App1(){

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

//        	Get a reference to the Statement
            theStatement = dbCon.createStatement();

//			System.out.println("Successfully connected to the database...");


        } catch (ClassNotFoundException e) {
            System.out.println("Can't load the Driver : " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Can't connect to DB : " + e.getMessage());
        }
    }

    public static void main( String[] args )
    {

//    	new App().getAllRecords();

        System.out.println("Please enter the Name, Address of Learner to add :");

        Scanner theScanner = new Scanner(System.in);

        String learnerName = theScanner.nextLine();

        String learnerAddress = theScanner.nextLine();

        new App1().addNewLearnerFromRuntime(learnerName, learnerAddress);

//
//    	int id = new Scanner(System.in).nextInt();
//
//    	new App().getLearnerDetailsById(id);

//    	new App().addNewLearner();

    }



    //    Get All Records from table:learners
    void getAllRecords() {
//    	Write the query to fetch all rows from table:learners
        qry = "select * from learners";

        try {


//			Execute the query
            ResultSet theResultSet = theStatement.executeQuery(qry);

//			Traverse through the results
            while(theResultSet.next()) {
                System.out.print("Name : " + theResultSet.getString("learnerName"));
                System.out.print(", ID : " + theResultSet.getInt("learnerId"));
                System.out.println(", Address : " + theResultSet.getString("learnerAddress"));
            }

        } catch (SQLException e) {
            System.out.println("Can't get a reference to Statement : " + e.getMessage());
        }
    }



    // Get Learner details for a particular id
    void getLearnerDetailsById(int id) {
//    	Write the query to fetch details from the table:learners
        qry = "select * from learners where learnerId = " + id;


        try {
//        	Execute the query
            ResultSet theResultSet = theStatement.executeQuery(qry);

            System.out.println("Details of learner for id : " + id);

//			Traverse through the results
            while(theResultSet.next()) {
                System.out.println("Name : " + theResultSet.getString("learnerName") + ", Address : " + theResultSet.getString("learnerAddress"));
            }


        } catch (SQLException e) {
            System.out.println("Can't execute the query : " + e.getMessage());
        }
    }



    //Add a new Learner to the table:learners
    void addNewLearner() {
//    Write the query to insert a new record
        qry = "insert into learners(learnerName, learnerAddress) values ('Alexander', 'Seattle, USA')";


        try {
//        	Execute the query
            int result = theStatement.executeUpdate(qry);

            if(result > 0)
                System.out.println("New Learner details addedd successfully...");
        } catch (SQLException e) {
            System.out.println("Can't add to the table : " + e.getMessage());
        }
    }


    //    Add a new Learner to the table:learners - learner details taken from runtime
    void addNewLearnerFromRuntime(String lName, String lAddress) {
//    	Write the query to insert a new record
        qry = "insert into learners(learnerName, learnerAddress) "
                + "values "
                + "('"
                + lName + "','"
                + lAddress + "')";


        try {
//        	Execute the query
            if(theStatement.executeUpdate(qry) >  0)
                System.out.println("Successfully added a new learner...");
        } catch (SQLException e) {
            System.out.println("Can't add to the table : " + e.getMessage());
        }
    }

    //    Update an already existing Learner
    void updateLearnerById(int id, String learnerName, String learnerAddress) {
        //Write the query to update
        qry = "update learners set learnerName = '" + learnerName + "', learnerAddress = '" + learnerAddress + "' where learnerId = "
                + "'" + id + "'";

//    	Execute the query
        try {
            if(theStatement.executeUpdate(qry) > 0)
                System.out.println("Learner details updated successfully...");
        } catch (SQLException e) {
            System.out.println("Can't update : " + e.getMessage());
        }}
    //       delete the query
    void deleteLearner(int id) {
        qry = "DELETE FROM `learners` WHERE `learners`.`learnerid` = "+id;

        try {
            theStatement.executeUpdate(qry);
            System.out.println("Delete was successful");
        } catch (SQLException e) {
            System.out.println("Delete was not successful "+e.getMessage());
        }
    }


}