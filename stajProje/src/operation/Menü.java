package operation;

import java.util.Scanner;
import org.apache.log4j.Logger;

public class Menü {

    Scanner scanner = new Scanner(System.in);
    DaoStudent daoS = new DaoStudent();
    DaoLesson daoL = new DaoLesson();
    DaoNote daoN = new DaoNote();
    static Logger log = Logger.getLogger(DbConnection.class.getName());

    public void firstMenü() {
        DbConnection.getInstance();
        log.info("Chose your area of oparation\n1-Student\n2-Lesson\n3-Not\n0-exit");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    menüStudent();
                    break;
                case 2:
                    menüLesson();
                    break;
                case 3:
                    menüNot();
                    break;
            }
            log.info("Chose your oparation\n1-Student\n2-Lesson\n3-Not\n0-exit");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void menüStudent() {
        log.info("Chose your oparation for student \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    daoS.list();
                    break;
                case 2:
                    daoS.add();
                    break;
                case 3:
                    daoS.delete();
                    break;
                case 4:
                    daoS.update();
                    break;
                case 5:
            }
            log.info("Chose your oparation for student\n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void menüLesson() {
        log.info("Chose your oparation for lesson \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    daoL.list();
                    break;
                case 2:
                    daoL.add();
                    break;
                case 3:
                    daoL.delete();
                    break;
                case 4:
                    daoL.update();
                    break;
                case 5:
            }
            log.info("Chose your oparation for lesson \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }

    public void menüNot() {
        log.info("Chose your oparation for Not \n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
        int chose = scanner.nextInt();
        do {
            switch (chose) {
                case 1:
                    daoN.list();
                    break;
                case 2:
                    daoN.add();
                    break;
                case 3:
                    daoN.delete();
                    break;
                case 4:
                    daoN.update();
                    break;
            }
            log.info("Chose your oparation for Not\n1-List\n2-Add\n3-Delete\n4-Update\n0-Back");
            chose = scanner.nextInt();
        } while (chose != 0);
    }
}
