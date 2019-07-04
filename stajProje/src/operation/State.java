package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class State {

    private ResultSet rs;
    private final String url = ("jdbc:sqlite:db0.db");
    private Connection con;
    private Statement st;
    static org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(DbConnection.class.getName());

    public ResultSet stQuery(String sorgu) {
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            log.info(rs);
            rs = st.executeQuery(sorgu);
            log.info(rs);
        } catch (SQLException ex) {
            log.error("stQuery");
        }

        return rs;
    }

    public Statement stUpdate(String sorgu) {
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException ex) {
            log.error("stUpdate");
        }
        return st;
    }

}
