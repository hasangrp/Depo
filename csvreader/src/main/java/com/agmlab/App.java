package com.agmlab;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class App {

    public static void main(String[] args) throws IOException {

        CsvReader csvReader = new CsvReader();
        List<Base> localList = csvReader.readCsv("local");
        List<Base> globalList = csvReader.readCsv("global");

        PrintWriter allSameWriter = new PrintWriter("allSame");
        PrintWriter justCGIWriter = new PrintWriter("justCGI");
        PrintWriter justGlobal = new PrintWriter("justGlobal");
        PrintWriter justLocal = new PrintWriter("justLocal");


        BasePredicates bp = new BasePredicates();

        for (int i = 0; i < globalList.size(); i++) {
            int flag = 0;
            for (int j = 0; j < localList.size(); j++) {
                if (bp.areAllSame.test(globalList.get(i), localList.get(j))) {
                    String out2 = "GLOBAL LIST : \n" + "ID : " + i + "\n" + globalList.get(i).toString() + "\n"
                            + "LOCAL LIST : \n" + "ID : " + j + "\n" + localList.get(j).toString();
                    allSameWriter.println(out2);
                }
                if (bp.areSameCGI.test(globalList.get(i), localList.get(j))) {
                    String out = "GLOBAL LIST : \n" + "ID : " + i + "\n" + globalList.get(i).toString() + "\n"
                        + "LOCAL LIST : \n" + "ID : " + j + "\n" + localList.get(j).toString();
                    justCGIWriter.println(out);
                    flag = 1;
                }
            }
            if (flag == 0){
                justGlobal.println(globalList.get(i).toString());
            }
        }

        for (Base base : localList) {
            int flag = 0;
            for (Base value : globalList) {
                if (bp.areSameCGI.test(base, value)) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                justLocal.println(base.toString());
            }
        }


        justLocal.close();
        justGlobal.close();
        allSameWriter.close();
        justCGIWriter.close();


    }

}
