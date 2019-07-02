package operation;

import java.util.Scanner;

public class MainOP {

    Scanner scanner = new Scanner(System.in);
    DbConnection db = new DbConnection();

    public void main0() {
        db.connect();
        System.out.println("Chose your area of oparation\n1-Student\n2-Lesson\n3-Not\n0-exit");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    mainStudent();
                    break;
                case 2:
                    mainLesson();
                    break;
                case 3:
                    mainNot();
                    break;
            }
            System.out.println("Chose your oparation\n1-Student\n2-Lesson\n3-Not\n0-exit");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void mainStudent() {
        System.out.println("Chose your oparation for student \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    db.listStudent();
                    break;
                case 2:
                    db.addStudent();
                    break;
                case 3:
                    db.deleteStudent();
                    break;
                case 4:
                    db.updateStudent();
                    break;
                case 5:
            }
            System.out.println("Chose your oparation for student\n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void mainLesson() {
        System.out.println("Chose your oparation for lesson \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    db.listLesson();
                    break;
                case 2:
                    db.addLesson();
                    break;
                case 3:
                    db.deleteLesson();
                    break;
                case 4:
                    db.updateLesson();
                    break;
                case 5:
            }
            System.out.println("Chose your oparation for lesson \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void mainNot() {
        System.out.println("Chose your oparation for Not \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    db.listNot();
                    break;
                case 2:
                    db.addNot();
                    break;
                case 3:
                    db.deleteNot();
                    break;
                case 4:
                    db.updateNot();
                    break;
            }
            System.out.println("Chose your oparation for Not\n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }
}
