import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Test2 {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        FileInputStream fis = null;

        try{
            fis = new FileInputStream("file/Db.properties");
            Properties p = new Properties();
            p.load(fis);

            String driverClass = p.getProperty("driverClass");
            String url = p.getProperty("url");
            String userName = p.getProperty("user");
            String password = p.getProperty("password");
            System.out.println(password);

            Class.forName(driverClass);
            con = DriverManager.getConnection(url,userName,password);
            System.out.println("Database Connected");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
