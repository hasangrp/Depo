package com.agmlab;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestRun {
    public static void main(String[] args) {

        Map<String,String> map1 = new HashMap<>();
        map1.put("1","one");
        map1.put("2","two");
        map1.put("1","deneme");
        Map<String,String> map2 = new HashMap<>();
        map2.put("1","one");
        map2.put("3","three");
        map2.put("4","four");
        map2.put("2","twoo");

        Iterator<String> it1 = map1.keySet().iterator();
        Iterator<String> it2= map2.keySet().iterator();

        while (it1.hasNext()){
            String s1 = it1.next();
            System.out.println(s1 + "--- \n");
            while (it2.hasNext()){

                String s2 = it2.next();


                System.out.println(s2);

            }
        }
    }
}
