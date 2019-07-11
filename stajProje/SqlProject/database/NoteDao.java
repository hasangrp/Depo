package database;

import java.sql.SQLException;
import java.util.Scanner;

public class NoteDao extends AbstractDao {

    private final String listQuery = "SELECT * from NOTE";
    Scanner scanner = new Scanner(System.in);

    public NoteDao() {
    }

    @Override
    public void list() {
        stQuery(listQuery);
        try {
            while (getRs().next()) {
                int student_no = getRs().getInt("STUDENT_NUMBER");
                int lesson_no = getRs().getInt("LESSON_NUMBER");
                int note = getRs().getInt("NOTE");
                log.info("Student No:" + student_no + "\t\tLesson No:" + lesson_no + "\t\tNot:" + note);
            }
        } catch (SQLException ex) {
            log.error("listNot");
        }
    }

    @Override
    public void add() {
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
            stUpdate(sorgu);
        }
    }

    @Override
    public void delete() {
        log.info("how many student note delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this student No:");
            int student_no = scanner.nextInt();
            log.info("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from NOTE where STUDENT_NUMBER=" + student_no + " and LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }

    @Override
    public void update() {
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
            stUpdate(sorgu);
        }
    }

}
