package database;

import java.sql.SQLException;
import java.util.Scanner;

public class LessonDao extends AbstractDao {

    private final String listQuery = "SELECT * from LESSON";
    Scanner scanner = new Scanner(System.in);

    public LessonDao() {
    }

    @Override
    public void list() {
        stQuery(listQuery);
        try {
            while (getRs().next()) {
                int lesson_no = getRs().getInt("LESSON_NUMBER");
                String lesson_name = getRs().getString("LESSON_NAME");
                log.info("Lesson No:" + lesson_no + "\t\tLesson Name:" + lesson_name);
            }
        } catch (SQLException ex) {
            log.error("listLesson");
        }
    }

    @Override
    public void add() {
        log.info("how many lesson add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("Lesson name:");
            String lesson_name = scanner.next();
            String sorgu = "INSERT INTO LESSON" + "(LESSON_NUMBER,lESSON_NAME)" + " VALUES(" + lesson_no + ",'" + lesson_name + "')";
            stUpdate(sorgu);
        }
    }

    @Override
    public void delete() {
        log.info("how many delete delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from LESSON where LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }

    @Override
    public void update() {
        log.info("how many lesson update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            log.info("Update this lesson No:");
            int lesson_no = scanner.nextInt();
            log.info("Lesson new name:");
            String lesson_name = scanner.next();
            String sorgu = "UPDATE LESSON Set LESSON_NAME='" + lesson_name + "' where LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }
}
