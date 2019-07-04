package operation;

import database.DbConnection;

public class Main {

    public static void main(String[] args) {
        Menu mop = new Menu();
        DbConnection.getInstance();
        mop.firstMenu();
    }
}
