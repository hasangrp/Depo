package com.agmlab;

import java.util.function.BiPredicate;

public class BasePredicates {

    public String changeNetworkString(Base l) {
        String networkType = "";
        switch (l.getRadioNetworkType()) {
            case "2G":
                networkType = "GSM";
                break;
            case "3G":
                networkType = "UMTS";
                break;
            case "4G":
                networkType = "LTE";
                break;
            case "GSM":
                networkType = "2G";
                break;
            case "UMTS":
                networkType = "3G";
                break;
            case "LTE":
                networkType = "4G";
                break;
        }
        return networkType;
    }

    public BiPredicate<Base, Base> areSameCGI = (g, l) -> {
        return g.getRadioNetworkType().equals(changeNetworkString(l))
                && g.getMobileCountryCode() == l.getMobileCountryCode()
                && g.getMobileNetworkCode() == l.getMobileNetworkCode()
                && g.getLocationAreaCode() == l.getLocationAreaCode();
    };

    public BiPredicate<Base, Base> areAllSame = (g, l) -> {
        if (areSameCGI.test(g, l)) {
            return g.getLongitude() == l.getLongitude()
                    && g.getLatitude() == l.getLatitude()
                    && g.getCellRange() == l.getCellRange();
        }
        return false;
    };

    public BiPredicate<Base, Base> diff = (g, l) -> {
        if (!(areSameCGI.test(g, l))) {
            return g.getLongitude() == l.getLongitude()
                    && g.getLatitude() == l.getLatitude()
                    && g.getCellRange() == l.getCellRange();
        }
        return true; 
    };


}
