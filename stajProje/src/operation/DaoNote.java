package operation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class DaoNote {

    Scanner scanner = new Scanner(System.in);
    private ResultSet rs ;
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private final String listNote = "SELECT * from NOTE";
    State state = new State();
    
    public void listNot() {
        state.stQuery(listNote);
        try {
            while (rs.next()) {
                int student_no = rs.getInt("STUDENT_NUMBER");
                int lesson_no = rs.getInt("LESSON_NUMBER");
                int note = rs.getInt("NOTE");
                log.info("Student No:" + student_no + "\t\tLesson No:" + lesson_no + "\t\tNot:" + note);
            }
        } catch (SQLException ex) {
            log.error("listNot");
        }
    }

    public void addNot() {
        log.info("how many student note Add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Add this student No:");
            int student_no = scanner.nextInt();
            log.info("Add this lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("Add Note:");
            int note = scanner.nextInt();
            String sorgu = "INSERT INTO NOTE SELECT " + student_no + "," + lesson_no + "," + note;
            state.stUpdate(sorgu);
        }
    }

    public void deleteNot() {
        log.info("how many student note delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this student No:");
            int student_no = scanner.nextInt();
            log.info("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from NOTE where STUDENT_NUMBER=" + student_no + " and LESSON_NUMBER=" + lesson_no;
            state.stUpdate(sorgu);
        }
    }

    public void updateNot() {
        log.info("how many student note update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Update this student No:");
            int student_no = scanner.nextInt();
            log.info("update this lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("New Not:");
            int note = scanner.nextInt();
            String sorgu = "UPDATE NOTE set NOTE=" + note + " Where STUDENT_NUMBER=" + student_no + " and LESSON_NUMBER=" + lesson_no;
            state.stUpdate(sorgu);
        }
    }
}
