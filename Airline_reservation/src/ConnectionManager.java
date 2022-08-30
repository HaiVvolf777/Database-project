import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionManager {
   private final String servername;
    private final String dbName;
    private final String DBuser;
    private final String DBpassword;

    ConnectionManager(String server, String db, String user, String password) {
       servername=server;
       dbName=db;
       DBuser=user;
       DBpassword=password;
    }
    
    public Connection getConnection() {
        try
        {
            
            Connection connect=DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CITdb;user=xylone;password=777777");
        return connect;
        
        }
        catch(Exception e){
            e.printStackTrace();
       
        }
        return null;
    }
    
}