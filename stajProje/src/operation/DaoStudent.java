package operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class DaoStudent {

    private ResultSet rs;
    Scanner scanner = new Scanner(System.in);
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private final String listStudent = "SELECT * from STUDENT";
    State state = new State();
    
    public void listStudent() {
        state.stQuery(listStudent);
        log.info(rs);
        try {
            while (rs.next()) {
                int student_no = rs.getInt("STUDENT_NUMBER");
                String name = rs.getString("NAME");
                int lesson_no = rs.getInt("LESSON_NUMBER");
                log.info("Student No:" + student_no + "\t\tName:" + name + "\t\tLesson No:" + lesson_no);
            }
        } catch (SQLException ex) {
            log.error("listStudent");
        }
    }

    public void addStudent() {
        log.info("how many student add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Student No:");
            int student_no = scanner.nextInt();
            log.info("Name:");
            String name = scanner.next();
            log.info("Lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "INSERT INTO STUDENT" + "(STUDENT_NUMBER,NAME,LESSON_NUMBER)" + " VALUES(" + student_no + ",'" + name + "'," + lesson_no + ")";
            state.stUpdate(sorgu);
        }
    }

    public void deleteStudent() {
        log.info("how many student delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this student No:");
            int student_no = scanner.nextInt();
            String sorgu = "Delete from STUDENT where STUDENT_NUMBER=" + student_no;
            state.stUpdate(sorgu);
        }
    }

    public void updateStudent() {
        log.info("how many student update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Update this student No:");
            int student_no = scanner.nextInt();
            log.info("Student new lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "UPDATE STUDENT Set LESSON_NUMBER=" + lesson_no + " where STUDENT_NUMBER=" + student_no;
            state.stUpdate(sorgu);
        }
    }
}
