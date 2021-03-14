package Phase2CMDLine;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCExample1 {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello");
        System.out.println("First Program");

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn1= DriverManager.getConnection("jdbc://mysql://localhost:3006/javaphase2","root", "");
        System.out.print("Connection established successfully");

    }
}
