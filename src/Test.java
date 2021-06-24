import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws Exception {
        //load and register the driver
        Class.forName("com.mysql.jdbc.Driver");

        // establish connection between java and database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
        System.out.println("Connection created");
        //create statement object
        Statement st =  con.createStatement();
        System.out.println("Statement created");


        //write and execute sql query
        String query = "CREATE TABLE Test ( id int , Name varchar(30), Gender varchar(30), Resutl double(10,3))";
        st.executeUpdate(query);
        System.out.println("Table test succesfully create");
        st.close();
        con.close();
        System.out.println("Connection closed succesfully");


    }
}