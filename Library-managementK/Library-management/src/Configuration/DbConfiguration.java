package Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {
    String url = System.getenv("DB_URL");
    String user = System.getenv("DB_USER");
    String password = System.getenv("DB_PASSWORD");

    public Connection Connect (){
        Connection conn = null ;

        try {
            conn = DriverManager.getConnection(url , user , password);
            System.out.println("Connected to postgresql successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn ;
    }
}
