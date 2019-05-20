import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.sql.Statement;


public class Main {


    public static void main(String[] args) throws SQLNonTransientConnectionException, IOException, SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://google/test?cloudSqlInstance=esysapp-209521:southamerica-east1:sd12019instance&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=test&password=testPassword123");
        
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT current_database();");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
                
        
        DataStreaming streaming = new DataStreaming("sub-c-b0d14910-0601-11e4-b703-02ee2ddab7fe", "pubnub-wikipedia");
        streaming.executeStreaming();
    }
}
