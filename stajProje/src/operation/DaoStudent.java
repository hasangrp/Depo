package operation;

import java.sql.SQLException;
import java.util.Scanner;

public class DaoStudent extends AbstractState{
private String listQuery = "SELECT * from STUDENT";
Scanner scanner = new Scanner(System.in);

    public DaoStudent() {
    }

    @Override
    public void list() {
        stQuery(listQuery);
        log.info(getRs());
        try {
            while (getRs().next()) {
                int student_no = getRs().getInt("STUDENT_NUMBER");
                String name = getRs().getString("NAME");
                int lesson_no = getRs().getInt("LESSON_NUMBER");
                log.info("Student No:" + student_no + "\t\tName:" + name + "\t\tLesson No:" + lesson_no);
            }
        } catch (SQLException ex) {
            log.error("listStudent");
        }
    }

    @Override
    public void add() {
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
            stUpdate(sorgu);
            }
    }
    @Override
    public void delete() {
         log.info("how many student delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this student No:");
            int student_no = scanner.nextInt();
            String sorgu = "Delete from STUDENT where STUDENT_NUMBER=" + student_no;
            stUpdate(sorgu);
        }

    }

    @Override
    public void update() {
           log.info("how many student update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Update this student No:");
            int student_no = scanner.nextInt();
            log.info("Student new lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "UPDATE STUDENT Set LESSON_NUMBER=" + lesson_no + " where STUDENT_NUMBER=" + student_no;
           stUpdate(sorgu);
        }
    }
}



