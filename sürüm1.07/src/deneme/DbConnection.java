package deneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DbConnection {

    private Connection con = null;
    private Statement st = null;
    Scanner scanner = new Scanner(System.in);

    public void connect() {

        try {
            //Class.forName("org.sqlite.JDBC");
            String url = ("jdbc:sqlite:db0.db");
            con = DriverManager.getConnection(url);
            System.out.println("başarılı");
        } catch (Exception e) {
            System.out.println("bağlatı başarısız..");
        }
    }

    public Statement getSt() {

        try {
            st = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        return st;
    }

    public void listStudent() {

        String sorgu = ("SELECT * from student");
        try {
            getSt();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()) {
                int ogrenci_no = rs.getInt("ogrenci_no");
                String ad = rs.getString("ad");
                int lesson_no = rs.getInt("lesson_no");
                System.out.println("Student No:" + ogrenci_no + "\t\tName:" + ad + "\t\tLesson No:" + lesson_no);
            }
        } catch (SQLException ex) {
            System.out.println("hata listStudent...");
        }
    }

    public void listLesson() {

        String sorgu = ("SELECT * from lesson");
        try {
            getSt();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()) {
                int lesson_no = rs.getInt("lesson_no");
                String lesson_name = rs.getString("lesson_name");
                int class_no = rs.getInt("class_no");
                System.out.println("Lesson No:" + lesson_no + "\t\tLesson Name:" + lesson_name + "\t\tClass No:" + class_no);
            }
        } catch (SQLException ex) {
            System.out.println("hata listLesson...");
        }
    }

    public void listClass() {

        String sorgu = ("SELECT * from class");
        try {
            getSt();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()) {
                int class_no = rs.getInt("class_no");
                String class_name = rs.getString("class_name");
                System.out.println("Class No:" + class_no + "\t\tClass name:" + class_name);
            }
        } catch (SQLException ex) {
            System.out.println("Hata listClass...");
        }
    }

    public void listNot() {

        String sorgu = ("SELECT * from note");
        try {
            getSt();
            ResultSet rs = st.executeQuery(sorgu);
            while (rs.next()) {
                int ogrenci_no = rs.getInt("ogrenci_no");
                int lesson_no = rs.getInt("lesson_no");
                int not = rs.getInt("not");
                System.out.println("Student No:" + ogrenci_no + "\t\tLesson No:" + lesson_no + "\t\tNot:" + not);
            }
        } catch (SQLException ex) {
            System.out.println("hata listNot...");
        }
    }

    public void addStudent() {

        System.out.println("how many student add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {

            try {

                System.out.println("Student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Name:");
                String ad = scanner.next();
                System.out.println("Lesson No:");
                int lesson_no = scanner.nextInt();
                String sorgu = "INSERT INTO student" + "(ogrenci_no,ad,lesson_no)" + " VALUES(" + ogrenci_no + ",'" + ad + "'," + lesson_no + ")";
                getSt();
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata addStudent...");
            }

        }
    }

    public void addLesson() {

        System.out.println("how many lesson add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {

            try {

                System.out.println("Lesson No:");
                int lesson_no = scanner.nextInt();
                System.out.println("Lesson name:");
                String lesson_name = scanner.next();
                System.out.println("Class No:");
                int class_no = scanner.nextInt();
                String sorgu = "INSERT INTO lesson" + "(lesson_no,lesson_name,class_no)" + " VALUES(" + lesson_no + ",'" + lesson_name + "'," + class_no + ")";
                getSt();
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata addLesson...");
            }

        }
    }

    public void addClass() {
        System.out.println("how many class add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {

            try {

                System.out.println("Class No:");
                int class_no = scanner.nextInt();
                System.out.println("Name:");
                String class_name = scanner.next();
                String sorgu = "INSERT INTO class" + "(class_no,class_name)" + " VALUES(" + class_no + ",'" + class_name + "')";
                getSt();
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata addClass...");
            }

        }
    }

    public void addNot() {
        System.out.println("how many student's note add:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {

            try {

                System.out.println("Student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Lesson No:");
                int lesson_no = scanner.nextInt();
                System.out.println("Not:");
                int not = scanner.nextInt();
                String sorgu = "INSERT INTO note" + "(ogrenci_no,lesson_no,not)" + " VALUES(" + ogrenci_no + "," + lesson_no + "," + not + ")";
                System.out.println(sorgu);
                getSt();
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata addNot...");
            }

        }
    }

    public void deleteStudent() {

        System.out.println("how many student delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                System.out.println("Delete this student No:");
                int ogrenci_no = scanner.nextInt();
                String sorgu = "Delete from student where ogrenci_no=" + ogrenci_no;
                getSt();
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata deleteStudent...");
            }

        }
    }

    public void deleteLesson() {

        System.out.println("how many delete delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                System.out.println("Delete this lesson No:");
                int lesson_no = scanner.nextInt();
                String sorgu = "Delete from lesson where lesson_no=" + lesson_no;
                getSt();
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata deleteLesson...");
            }

        }
    }

    public void deleteClass() {

        System.out.println("how many class delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                System.out.println("Delete this class No:");
                int class_no = scanner.nextInt();
                String sorgu = "Delete from class where class_no=" + class_no;
                getSt();
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata deleteClass...");
            }

        }
    }

    public void deleteNot() {

        System.out.println("how many student not delete:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                System.out.println("Delete this student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Delete this lesson No:");
                int lesson_no = scanner.nextInt();
                String sorgu = "Delete from note where ogrenci_no=" + ogrenci_no + " and lesson_no=" + lesson_no;
                getSt();
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata deleteNot...");
            }

        }
    }

    public void updateStudent() {

        System.out.println("how many student update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                getSt();
                System.out.println("Update this student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Student new lesson No:");
                int lesson_no = scanner.nextInt();
                String sorgu = "UPDATE student Set lesson_no=" + lesson_no + " where ogrenci_no=" + ogrenci_no;
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata updateStudent...");
            }
        }
    }

    public void updateLesson() {

        System.out.println("how many lesson update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                getSt();
                System.out.println("Update this lesson No:");
                int lesson_no = scanner.nextInt();
                System.out.println("Lesson new name:");
                String lesson_name = scanner.next();
                String sorgu = "UPDATE lesson Set lesson_name='" + lesson_name + "' where lesson_no=" + lesson_no;
                System.out.println(sorgu);
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata updateLesson...");
            }
        }
    }

    public void updateClass() {

        System.out.println("how many class update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                getSt();
                System.out.println("Update this class No:");
                int class_no = scanner.nextInt();
                System.out.println("Class new name:");
                String class_name = scanner.next();
                String sorgu = "UPDATE class Set class_name='" + class_name + "' where class_no=" + class_no;
                st.executeUpdate(sorgu);

            } catch (SQLException ex) {
                System.out.println("hata updateClass...");
            }
        }
    }

    public void updateNot() {

        System.out.println("how many student not update:");
        int i = scanner.nextInt();
        for (int a = 0; a < i; a++) {
            try {
                getSt();
                System.out.println("Update this student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("update this lesson No:");
                int lesson_no = scanner.nextInt();
                System.out.println("New Not:");
                int not = scanner.nextInt();
                String sorgu = "UPDATE note Set not=" + not + " where ogrenci_no=" + ogrenci_no + " and lesson_no=" + lesson_no;
                st.executeUpdate(sorgu);
            } catch (SQLException ex) {
                System.out.println("hata updateNot...");
            }
        }
    }

}
