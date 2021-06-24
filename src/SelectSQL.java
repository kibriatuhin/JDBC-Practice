import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.regex.Pattern;

public class SelectSQL {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            //load and register driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Load and register successfull");

            //establish connection between java and database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");

            //create statement object
            st = con.createStatement();

            // write and execute sql query
            rs = st.executeQuery("select * from student1");
            System.out.println("id\tname\tgender\t");
            System.out.println("------------------------");
            while (rs.next()){
                System.out.print(rs.getInt(1) + "\t");
                System.out.print(rs.getString(2)+ "\t" );
                System.out.print(rs.getString(3)+ "\t");
                System.out.println();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
