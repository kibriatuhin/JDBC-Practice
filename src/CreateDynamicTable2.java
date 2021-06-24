import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDynamicTable2 {
    public static void main(String[] args) throws  Exception {
        //load and register driver
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver load successfull");

        // establish connection between java and database
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Tuhin" , "root" , "" );
        System.out.println("Connection successfull...");

        // create statement object
        Statement st = con.createStatement();
        System.out.println("successfull to create statement object...");

        // write and execute sql query
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter table Name  : " );
        String tableName = br.readLine();
        String primaryKeyColumn = "";
        //CREATE TABLE Test ( id int , Name varchar(30), Gender varchar(30), Resutl double(10,3))
        String query = "create table " + tableName + "(";
        while (true){
            System.out.print("Enter Column Name : ");
            String columnName = br.readLine();

            System.out.print("Enter column Data type : ");
            String columnDataType = br.readLine();

            System.out.print("Enter column data type size : ");
            int columnDataTypeSize = Integer.parseInt(br.readLine());

            query = query + columnName + " " + columnDataType + "(" + columnDataTypeSize + ")";

            System.out.print("Is primary key [Yes/No] : ");
            String primaryKeyOption = br.readLine();

            if (primaryKeyOption.equalsIgnoreCase("Yes"))
                primaryKeyColumn = primaryKeyColumn + columnName;

            System.out.print("One more Column[Yes/No] : ");
            String nextColumnOption = br.readLine();
            if (nextColumnOption.equalsIgnoreCase("Yes")){
                query = query +",";
                continue;
            }else {
                query = query + ", primary key(" + primaryKeyColumn+ "))";
                break;
            }

        }
        System.out.println(query);
        st.executeUpdate(query);
        System.out.println("Table "  + tableName + " created succesfully");
        br.close();
        st.close();
        con.close();




    }
}
