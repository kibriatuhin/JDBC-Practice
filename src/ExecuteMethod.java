import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class ExecuteMethod {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
            st = con.createStatement();
            boolean b = st.execute("select * from student1");
            System.out.println("Execute method output : " +b);
            rs = st.getResultSet();
            System.out.println("id\tname\tgender\t");
            System.out.println("---------");
            while (rs.next()){
                System.out.print(rs.getInt("id")+"\t");
                System.out.print(rs.getString("name") + "\t");
                System.out.print(rs.getString("gender") + "\t");
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
