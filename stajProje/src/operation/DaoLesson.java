package operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class DaoLesson {

    Scanner scanner = new Scanner(System.in);
    private ResultSet rs ;
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private final String listLesson = "SELECT * from LESSON";
    State state = new State();

    public void listLesson() {
        state.stQuery(listLesson);
        try {
            while (rs.next()) {
                int lesson_no = rs.getInt("LESSON_NUMBER");
                String lesson_name = rs.getString("LESSON_NAME");
                log.info("Lesson No:" + lesson_no + "\t\tLesson Name:" + lesson_name);
            }
        } catch (SQLException ex) {
            log.error("listLesson");
        }
    }

    public void addLesson() {
        log.info("how many lesson add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("Lesson name:");
            String lesson_name = scanner.next();
            String sorgu = "INSERT INTO LESSON" + "(LESSON_NUMBER,lESSON_NAME)" + " VALUES(" + lesson_no + ",'" + lesson_name + "')";
            state.stUpdate(sorgu);
        }
    }

    public void deleteLesson() {
        log.info("how many delete delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from LESSON where LESSON_NUMBER=" + lesson_no;
            state.stUpdate(sorgu);
        }
    }

    public void updateLesson() {
        log.info("how many lesson update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Update this lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("Lesson new name:");
            String lesson_name = scanner.next();
            String sorgu = "UPDATE LESSON Set LESSON_NAME='" + lesson_name + "' where LESSON_NUMBER=" + lesson_no;
            state.stUpdate(sorgu);
        }
    }
}
