package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public abstract class AbstractDao {

    private final String url = ("jdbc:sqlite:db0.db");
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private Connection con;
    private ResultSet rs;
    private Statement st;
   
    public ResultSet getRs() {
        return rs;
    }
    
    public AbstractDao() {
    }

    public ResultSet stQuery(String sorgu) {
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
        } catch (SQLException ex) {
            log.info("stQuery");
        }
        return rs;
    }

    public Statement stUpdate(String sorgu) {
        try {
            con = DriverManager.getConnection(url);
            st = con.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException ex) {
            log.error("getSt");
        }
        return st;

    }

    public abstract void list();

    public abstract void add();

    public abstract void delete();

    public abstract void update();

}
