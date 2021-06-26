import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ExecuteMethod2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        BufferedReader br = null;
        java.sql.ResultSetMetaData rmd = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
            st = con.createStatement();
            br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter SQL query = ");
            String query = br.readLine();
            boolean b = st.execute(query);
            if (b==true){
                ResultSet rs = st.getResultSet();
                 rmd = rs.getMetaData();
                 int rowCount = rmd.getColumnCount();
                 for (int i=1 ;i<=rowCount ; i++){
                     System.out.print(rmd.getColumnName(i) + "\t");
                 }
                System.out.println();
                System.out.println("---------------------------");
                while (rs.next()){
                    for (int i=1 ;i<=rowCount ; i++){
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }

            }else {
                int rowCount = st.getUpdateCount();
                System.out.println("Rowcount update" + rowCount);
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
