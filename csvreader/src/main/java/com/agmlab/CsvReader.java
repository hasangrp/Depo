package com.agmlab;

import java.io.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CsvReader {
    private final String GLOBAL_CSV_FILE_PATH = "C:\\Users\\hasan\\Desktop\\csvreader\\src\\main\\resources\\global-min.csv";
    private final String LOCAL_CSV_FILE_PATH = "C:\\Users\\hasan\\Desktop\\csvreader\\src\\main\\resources\\local-min.csv";

    private int flag = 0;

    public List<Base> readCsv(String type) throws IOException {
        List<Base> baseList;
        File f;
        if (type.equals("local")) {
            f = new File(LOCAL_CSV_FILE_PATH);
        } else {
            f = new File(GLOBAL_CSV_FILE_PATH);
            flag = 1;
        }
        InputStream inputStream = new FileInputStream(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        baseList = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
        return baseList;
    }

    private Function<String, Base> mapToItem = (line) -> {
        String[] p = line.split(",");
        Base base;
        if (flag == 0) {
            base = new Local();
        } else {
            base = new Global();
        }

        base.setRadioNetworkType(p[0]);
        base.setMobileCountryCode(Integer.parseInt(p[1]));
        base.setMobileNetworkCode(Integer.parseInt(p[2]));
        base.setLocationAreaCode(Integer.parseInt(p[3]));
        if (flag == 0) {
            base.setLongitude(Double.parseDouble(p[4]));
            base.setLatitude(Double.parseDouble(p[5]));
            base.setCellRange(Integer.parseInt(p[6]));
        } else {
            base.setLongitude(Double.parseDouble(p[6]));
            base.setLatitude(Double.parseDouble(p[7]));
            base.setCellRange(Integer.parseInt(p[8]));
        }

        return base;
    };

//    public List<Global> readGlobalCsv() throws IOException {
//        List<Global> globalList = null;
//        try (Reader reader = Files.newBufferedReader(Paths.get(GLOBAL_CSV_FILE_PATH));) {
//            CsvToBean<Global> csvToBean = new CsvToBeanBuilder(reader)
//                    .withType(Global.class)
//                    .withIgnoreLeadingWhiteSpace(true)
//                    .build();
//            Iterator<Global> globalIterator = csvToBean.iterator();
//            globalList = new ArrayList<>();
//            while (globalIterator.hasNext()) {
//                Global global = globalIterator.next();
//                globalList.add(global);
//            }
//        }
//        return globalList;
//    }
}
