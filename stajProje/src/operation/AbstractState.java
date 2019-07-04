package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public abstract class AbstractState {
    private final String url = ("jdbc:sqlite:db0.db");
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private Connection con;
    private ResultSet rs;
    private Statement st;

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public abstract ResultSet stQuery(String sorgu);

    public abstract Statement stUpdate(String sorgu);

    public class State1 extends AbstractState {

        @Override
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

        @Override
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
    }

}
