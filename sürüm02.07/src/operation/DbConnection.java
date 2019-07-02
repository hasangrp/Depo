package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import org.apache.log4j.Logger;

public class DbConnection {

    private Connection con = null;
    private Statement st = null;
    private ResultSet rs = null;
    Scanner scanner = new Scanner(System.in);
    static Logger log = Logger.getLogger(DbConnection.class.getName());
    private final String listStudent = "SELECT * from STUDENT";
    private final String listLesson = "SELECT * from LESSON";
    private final String listNot = "SELECT * from NOTE";

    public void connect() {

        try {
            String url = ("jdbc:sqlite:db0.db");
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            log.info("Connection failed...");
        }
    }

    public ResultSet stQuery(String sorgu) {
        try {
            st = con.createStatement();
            rs = st.executeQuery(sorgu);
        } catch (SQLException ex) {
            log.error("stQuery...");
        }
        return rs;
    }

    public Statement stUpdate(String sorgu) {
        try {
            st = con.createStatement();
            st.executeUpdate(sorgu);
        } catch (SQLException ex) {
            log.error("getSt...");
        }
        return st;
    }

    public void listStudent() {
        stQuery(listStudent);
        try {
            while (rs.next()) {
                int student_no = rs.getInt("STUDENT_NUMBER");
                String name = rs.getString("NAME");
                int lesson_no = rs.getInt("LESSON_NUMBER");
                System.out.println("Student No:" + student_no + "\t\tName:" + name + "\t\tLesson No:" + lesson_no);
            }
        } catch (SQLException ex) {
            log.error("listStudent...");
        }
    }

    public void listLesson() {
        stQuery(listLesson);
        try {
            while (rs.next()) {
                int lesson_no = rs.getInt("LESSON_NUMBER");
                String lesson_name = rs.getString("LESSON_NAME");
                System.out.println("Lesson No:" + lesson_no + "\t\tLesson Name:" + lesson_name);
            }
        } catch (SQLException ex) {
            log.error("listLesson");
        }
    }

    public void listNot() {
        stQuery(listNot);
        try {
            while (rs.next()) {
                int student_no = rs.getInt("STUDENT_NUMBER");
                int lesson_no = rs.getInt("LESSON_NUMBER");
                int note = rs.getInt("NOTE");
                System.out.println("Student No:" + student_no + "\t\tLesson No:" + lesson_no + "\t\tNot:" + note);
            }
        } catch (SQLException ex) {
            log.error("listNot");
        }
    }

    public void addStudent() {
        System.out.println("how many student add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Student No:");
            int student_no = scanner.nextInt();
            System.out.println("Name:");
            String name = scanner.next();
            System.out.println("Lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "INSERT INTO STUDENT" + "(STUDENT_NUMBER,NAME,LESSON_NUMBER)" + " VALUES(" + student_no + ",'" + name + "'," + lesson_no + ")";
            stUpdate(sorgu);
        }
    }

    public void addLesson() {
        System.out.println("how many lesson add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Lesson No:");
            int lesson_no = scanner.nextInt();
            System.out.println("Lesson name:");
            String lesson_name = scanner.next();
            String sorgu = "INSERT INTO LESSON" + "(LESSON_NUMBER,lESSON_NAME)" + " VALUES(" + lesson_no + ",'" + lesson_name + "')";
            stUpdate(sorgu);
        }
    }
    
    public void addNot() {
        System.out.println("how many student note Add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Add this student No:");
            int student_no = scanner.nextInt();
            System.out.println("Add this lesson No:");
            int lesson_no = scanner.nextInt();
            System.out.println("Add Note:");
            int note = scanner.nextInt();
            String sorgu = "INSERT INTO NOTE SELECT " + student_no + ","+ lesson_no + "," + note;
            stUpdate(sorgu);
        }
    }

    public void deleteStudent() {
        System.out.println("how many student delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Delete this student No:");
            int student_no = scanner.nextInt();
            String sorgu = "Delete from STUDENT where STUDENT_NUMBER=" + student_no;
            stUpdate(sorgu);
        }
    }

    public void deleteLesson() {
        System.out.println("how many delete delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from LESSON where LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }

    public void deleteNot() {
        System.out.println("how many student note delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Delete this student No:");
            int student_no = scanner.nextInt();
            System.out.println("Delete this lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "Delete from NOTE where STUDENT_NUMBER=" + student_no + " and LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }

    public void updateStudent() {
        System.out.println("how many student update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Update this student No:");
            int student_no = scanner.nextInt();
            System.out.println("Student new lesson No:");
            int lesson_no = scanner.nextInt();
            String sorgu = "UPDATE STUDENT Set LESSON_NUMBER=" + lesson_no + " where STUDENT_NUMBER=" + student_no;
            stUpdate(sorgu);
        }
    }

    public void updateLesson() {
        System.out.println("how many lesson update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Update this lesson No:");
            int lesson_no = scanner.nextInt();
            System.out.println("Lesson new name:");
            String lesson_name = scanner.next();
            String sorgu = "UPDATE LESSON Set LESSON_NAME='" + lesson_name + "' where LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }

    public void updateNot() {
        System.out.println("how many student note update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            System.out.println("Update this student No:");
            int student_no = scanner.nextInt();
            System.out.println("update this lesson No:");
            int lesson_no = scanner.nextInt();
            System.out.println("New Not:");
            int note = scanner.nextInt();
            String sorgu = "UPDATE NOTE set NOTE=" + note + " Where STUDENT_NUMBER=" + student_no + " and LESSON_NUMBER=" + lesson_no;
            stUpdate(sorgu);
        }
    }
}
