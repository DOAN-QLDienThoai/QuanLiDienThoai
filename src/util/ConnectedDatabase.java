package util;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectedDatabase {
private static SQLServerDataSource ds = new SQLServerDataSource();
    public static Connection getConnectedDB() {
                 
		var server = "localhost";  
        var user = "sa";                 
        var password = "161105";          
        var db = "log";              
        var port = 1433;                  

        ds.setUser(user);
        ds.setPassword(password);
        ds.setDatabaseName(db);
        ds.setServerName(server);
        ds.setPortNumber(port);
        ds.setTrustServerCertificate(true);
     
    try {
        return ds.getConnection();
    } catch (SQLServerException ex) {
       
        Logger.getLogger(ConnectedDatabase.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null ;
	}
    public static void closeConnectedDB(Connection c) {
		try {
			if(c!=null) {
				c.close();
				System.out.println("Đóng thành công !");
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Không thể đóng ");
		}
	}

    public static com.sun.jdi.connect.spi.Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}