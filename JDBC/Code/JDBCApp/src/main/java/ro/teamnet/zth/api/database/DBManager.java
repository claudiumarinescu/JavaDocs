package ro.teamnet.zth.api.database;

import java.sql.*;
import java.util.Properties;

/**
 * Created by Claudiu.Marinescu on 7/13/2017.
 */
public class DBManager {

    private static final String CONNECTION_STRING = "jdbc:oracle:thin:@"
            + DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private DBManager() throws UnsupportedOperationException {}

    private static void registerDriver() {
        try {
            Driver myDriver = new oracle.jdbc.driver.OracleDriver();
            DriverManager.registerDriver(myDriver);
        } catch (SQLException e) {
            System.out.println("Error: unable to load driver class!");
            System.exit(1);
        }
    }

    public static Connection getConnection() {
        DBManager.registerDriver();
        Properties properties = new Properties();
        properties.put("user", DBProperties.USER);
        properties.put("password", DBProperties.PASS);
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static int checkConnection(Connection connection) {
        if (connection == null)     return -1;
        String statement = "SELECT 1 FROM DUAL";
        try (Statement stmt = connection.createStatement()) {
            if (stmt.execute(statement)) {
                return 0;
            } else {
                return -1;
            }
        } catch (SQLException e) {
            System.out.println("Error: unable to create new statement!");
            return -1;
        }
    }

}
