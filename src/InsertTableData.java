import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class InsertTableData {
    public static void main(String[] args) {
        BufferedReader br = null;
        Connection con = null;
        Statement st = null;
        try {
            //load and register driver
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("load and register successfully");

            //establish connection between java and database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "");
            System.out.println("Connection succesfully");

            // create statement object
            st = con.createStatement();
            System.out.println("statement succesfully");

            br = new BufferedReader(new InputStreamReader(System.in));
            while (true){
                System.out.print("Enter id number = ");
                int id = Integer.parseInt(br.readLine());

                System.out.print("Enter Your name = ");
                String name = br.readLine();

                System.out.print("Enter gender = ");
                String gender = br.readLine();

                System.out.print("Enter salary = ");
                double salary = Double.parseDouble(br.readLine());

                String query = "insert into Test2 values('"+id+"' , '"+name+"' , '"+gender+"' , '"+salary+"')";
                System.out.println(query);
                int rowCount = st.executeUpdate(query);
                if (rowCount==1)
                    System.out.println("Id " + id + " succesfully insert");
                else
                    System.out.println("failure");

                System.out.print("One more student [Yes/No] = ");
                String option = br.readLine();
                if (option.equalsIgnoreCase("Yes"))
                    continue;
                else
                    break;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                br.close();
                st.close();
                con.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
}
