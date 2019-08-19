package com.agmlab;

import data.entity.GlobalParametr;
import data.entity.LocalParametr;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.util.Iterator;
import java.util.List;

public class ReadFile {

    private final String fileNameGlobal = ("D:\\csv\\global-50.csv");
    private final String fileNameLocal = ("C:\\csv\\local-50.csv");
    List<GlobalParametr> globalList = null;
    List<LocalParametr> localList = null;
    Integer[] localExist = new Integer[50];
    int sayDifLocal ;

    public List<LocalParametr> localReader() throws IOException {
        try (Reader read = Files.newBufferedReader(Paths.get(fileNameLocal));) {
            CsvToBean<LocalParametr> csvToBean = new CsvToBeanBuilder(read)
                    .withType(LocalParametr.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<LocalParametr> csvLocalIterator = csvToBean.iterator();
            localList = new ArrayList<>();
            while (csvLocalIterator.hasNext()) {
                LocalParametr local = csvLocalIterator.next();
                localList.add(local);

            }
        }

        return localList;
    }

    public List<GlobalParametr> globalReader() throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(fileNameGlobal));) {
            CsvToBean<GlobalParametr> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(GlobalParametr.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<GlobalParametr> csvGlobalIterator = csvToBean.iterator();
            globalList = new ArrayList<>();
            while (csvGlobalIterator.hasNext()) {
                GlobalParametr global = csvGlobalIterator.next();
                globalList.add(global);
            }
        }
        return globalList;
    }

    public void sameArray() {
        int saySame = 0;
        int saySci = 0;
        Integer[] globalExist = new Integer[globalList.size()];
        int sayDifGlobal = 0;
        for (int i = 0; i < localList.size(); i++) {
            String radioType = localList.get(i).getRadioNetworkType();
            switch (radioType) {
                case "2G":
                    radioType = "GSM";
                    break;
                case "3G":
                    radioType = "UMTS";
                    break;
                case "4G":
                    radioType = "LTE";
                    break;
                default:
                    break;
            }
            for (int j = 0; j < globalList.size(); j++) {
                if (localList.get(i).getMobileCountryCode() == globalList.get(j).getMcc() && localList.get(i).getMobileNetworkCode() == globalList.get(j).getNet() && localList.get(i).getLocationAreaCode() == globalList.get(j).getArea() && localList.get(i).getLongitude() == globalList.get(j).getLon() && localList.get(i).getLatitute() == globalList.get(j).getLan() && localList.get(i).getRange() == globalList.get(j).getGlobalRange() && globalList.get(j).getRadio().equals(radioType)) {
                    saySame++;
                    System.out.println("\nID Same SCI && Same Parametr--" + saySame);
                    System.out.println("\nGlobal-Local RadioType: " + globalList.get(j).getRadio());
                    System.out.println("Global-Local MobileCountryCode: " + globalList.get(j).getMcc());
                    System.out.println("Global-Local MobileNetwoekCode: " + globalList.get(j).getNet());
                    System.out.println("Global-Local LocationAreaCode: " + globalList.get(j).getArea());
                    System.out.println("Global-Local Longitude: " + globalList.get(j).getLon());
                    System.out.println("Global-Local Latitude: " + globalList.get(j).getLan());
                    System.out.println("Global-Local Range: " + globalList.get(j).getGlobalRange());
                    localExist[sayDifLocal] = i;
                  //  globalExist[sayDifGlobal] = j;
                } else if (localList.get(i).getMobileCountryCode() == globalList.get(j).getMcc() && localList.get(i).getMobileNetworkCode() == globalList.get(j).getNet() && localList.get(i).getLocationAreaCode() == globalList.get(j).getArea()) {
                    if (localList.get(i).getLongitude() != globalList.get(j).getLon() || localList.get(i).getLatitute() != globalList.get(j).getLan() || localList.get(i).getRange() != globalList.get(j).getGlobalRange() || !globalList.get(j).getRadio().equals(radioType)) {

                        saySci++;
                        System.out.println("\nID:Same SCI && Difirent Parametr--" + saySci);
                        System.out.println("\nGlobal-Local MobileCountryCode: " + globalList.get(j).getMcc());
                        System.out.println("Global-Local MobileNetwoekCode: " + globalList.get(j).getNet());
                        System.out.println("Global-Local LocationAreaCode: " + globalList.get(j).getArea());
                        System.out.println("Global Local RadioType: " + globalList.get(j).getRadio() + "\t\tLocal RadioType: " + localList.get(i).getRadioNetworkType());
                        System.out.println("Global Longitude: " + globalList.get(j).getLon() + "\t\tLocal Longitude: " + localList.get(i).getLongitude());
                        System.out.println("Global Latitude: " + globalList.get(j).getLan() + "\t\tLocal Latitude: " + localList.get(i).getLatitute());
                        System.out.println("Global Range: " + globalList.get(j).getGlobalRange() + "\t\t\tLocal Range: " + localList.get(i).getRange());
                        localExist[sayDifLocal] = i;
                //        globalExist[sayDifGlobal] = j;
                    }

                }
              // sayDifGlobal++;
            }
            System.out.println(sayDifLocal);
            System.out.println(localExist[sayDifLocal]);
            sayDifLocal++;
        }
    }
    public void justLocal(){
           for (int k = 0; k < 50; k++) {
            System.out.println("\nThis sci Local is exist Global is not exist-- " + sayDifLocal);
            System.out.println("\nLocal RadioType: " + localList.get(localExist[k]).getRadioNetworkType());
            System.out.println("Local MobileCountryCode: " + localList.get(localExist[k]).getMobileCountryCode());
            System.out.println("Local MobileNetworkCode: " + localList.get(localExist[k]).getMobileNetworkCode());
            System.out.println("Local LocationAreaCode: " + localList.get(localExist[k]).getLocationAreaCode());
            System.out.println("Local Longitude: " + localList.get(localExist[k]).getLongitude());
            System.out.println("Local Latitude: " + localList.get(localExist[k]).getLatitute());
            System.out.println("Local Range: " + localList.get(localExist[k]).getRange());
        }
        
    }
}
