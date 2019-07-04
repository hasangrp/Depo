package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DbConnection {

    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private final String url = ("jdbc:sqlite:db0.db");
    private static DbConnection dbConnection = null;
    private Connection con=null;

    private DbConnection() {
        try {
            con = DriverManager.getConnection(url);
            log.info("Connection successful");
        } catch (SQLException e) {
            log.info("Connection failed");
        }
    }

    public static DbConnection getInstance() {
        if (dbConnection == null) {
            dbConnection = new DbConnection();
        }

        return dbConnection;
    }
}
