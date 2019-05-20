import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PSQLConnection {

    Connection connection;

    public PSQLConnection(String credential){
        try{
            this.connection = DriverManager.getConnection(credential);
        } catch(SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
