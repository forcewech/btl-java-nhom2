
package Database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class DatabaseHelper {
    public static final String connectionUrl = "jdbc:sqlserver://21AK22-COM\\SQLEXPRESS:1433" + 
        "databaseName=QLTaiSanPhongMay;user=sa;password=123456;encrypt=true;trustServerCertificate=true;";
    public static Connection getDBConnection() {
   Connection conn = null;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch(Exception ex) {
        System.out.println("chua co Driver!" + ex.toString());
    }
    try {
        conn = DriverManager.getConnection(connectionUrl);
        return conn;
    } catch(Exception ex) {
        System.out.println("Loi connection" + ex.toString());
    }
    return null;
    }
}
