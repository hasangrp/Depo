package com.agmlab;

import java.io.IOException;
import org.apache.log4j.Logger;

public class App {

 static Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws IOException  {
       ReadFile readFile = new ReadFile();
       readFile.localReader();
       readFile.globalReader();
       readFile.sameArray();
      readFile.justLocal();
//readFile.compareSCI();
       //readFile.compareAngle();
       //readFile.compareRange();
    }
}
