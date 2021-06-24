import java.sql.*;

public class ResultSetMetaData {
    public static void main(String[] args) {
         Connection con = null;
         Statement st  = null;
         ResultSet rs = null;
         java.sql.ResultSetMetaData md = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("load driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
            System.out.println("connection succesfully");



            st = con.createStatement();
            System.out.println("statement object create");

            rs = st.executeQuery("select * from  student1");
            System.out.println("execute update method done");
            md = rs.getMetaData();
            System.out.println("metadata object done");
            int columnCount = md.getColumnCount();
            System.out.println("Number of column = " + columnCount);
            for (int  i =1 ;i<= columnCount ; i++){
                System.out.println("Column Name = " + md.getColumnName(i));
                System.out.println("Column data type = " + md.getColumnTypeName(i));
                System.out.println("Column size = " + md.getColumnDisplaySize(i));
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
