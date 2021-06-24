import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class createDynamicTable {
    public static void main(String[] args) throws Exception {
        //load and register driver
        Class.forName("com.mysql.jdbc.Driver");

        //establish connection between java and database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "" );

        //create statement object
        Statement st = con.createStatement();

        //write sql equery
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter SQL table name : ");
        String tName = br.readLine();

        st.executeUpdate("CREATE TABLE "+tName+" ( id int , Name varchar(30), Gender varchar(30), Resutl double(10,3))");
        System.out.println("Table "+tName+ " created succesfully");
        br.close();
        st.close();
        con.close();



    }
}
