import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ResutlSetMetaData2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        java.sql.ResultSetMetaData rmd = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
            st = con.createStatement();
            rs = st.executeQuery("select * from student1");
            rmd = rs.getMetaData();
            int columnCount = rmd.getColumnCount();
            for (int i=1 ; i<=columnCount ; i++){
                System.out.print(rmd.getColumnName(i) + "\t");
            }
            System.out.println();
            System.out.println("-------------------------");
            while (rs.next()){
                for (int i=1 ; i<=columnCount ; i++){
                    System.out.print(rs.getString(i) + "\t");
                }
                System.out.println();
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
