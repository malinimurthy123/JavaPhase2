import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App
{
    String qry;
    Connection dbCon;
    Statement theStatement;

    App(){

        try {
//    		Define the URL to connect
            String urlToConnect = "jdbc:mysql://localhost:3306/javaphase2";

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

    public static void main( String[] args ) throws SQLException {

        new App().getAllRecords();

        //System.out.println("Please enter the ID:");

        //int id = new Scanner(System.in).nextInt();

        //new App().getLearnerDetailsById(id);

        new App().addNewUser();

        //new App().updateExisstingUser();

        //new App().deleteExisstingUser();

    }


    //    Get All Records from table:learners
    void getAllRecords() {
//    	Write the query to fetch all rows from table:learners
        qry = "select * from users";

        try {


//			Execute the query
            ResultSet theResultSet = theStatement.executeQuery(qry);

//			Traverse through the results
            while(theResultSet.next()) {
                System.out.print("Name : " + theResultSet.getString("Name"));
                System.out.print(", ID : " + theResultSet.getInt("Id"));
                System.out.println(", Location : " + theResultSet.getString("Location"));
            }

        } catch (SQLException e) {
            System.out.println("Can't get a reference to Statement : " + e.getMessage());
        }
    }



    // Get Learner details for a particular id
    void getLearnerDetailsById(int id) {
//    	Write the query to fetch details from the table:learners
        qry = "select * from users where Id = " + id;


        try {
//        	Execute the query
            ResultSet theResultSet = theStatement.executeQuery(qry);

            System.out.println("Details of learner for id : " + id);

//			Traverse through the results
            while(theResultSet.next()) {
                System.out.println("Name : " + theResultSet.getString("Name") + ", Location : " + theResultSet.getString("Location"));
            }


        } catch (SQLException e) {
            System.out.println("Can't execute the query : " + e.getMessage());
        }
    }

    //Add new user

    void addNewUser() throws SQLException {
        //Insert new record

        qry="insert into users(Id, name, Location) values(4, 'Balaji', 'SriLanka')";
        theStatement.executeUpdate(qry);

    }


    void updateExisstingUser() throws SQLException {
        //Update existing record

        qry="UPDATE `users` SET name = 'malinikr',Location='USA' WHERE `Id`=0";
        theStatement.executeUpdate(qry);

    }

    void deleteExisstingUser() throws SQLException {
        //Update existing record

        qry="Delete from  users";
        theStatement.executeUpdate(qry);

    }

}