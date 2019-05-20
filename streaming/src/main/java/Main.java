
public class Main {


    public static void main(String[] args) {
        
        DataStreaming streaming = new DataStreaming("sub-c-b0d14910-0601-11e4-b703-02ee2ddab7fe", "pubnub-wikipedia", "jdbc:postgresql://google/test?cloudSqlInstance=esysapp-209521:southamerica-east1:sd12019instance&socketFactory=com.google.cloud.sql.postgres.SocketFactory&user=test&password=testPassword123");
        streaming.executeStreaming();
    }
}
