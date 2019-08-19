package data.entity;

import com.opencsv.bean.CsvBindByName;

public class LocalParametr {
   
    @CsvBindByName(column = "RADIO_NETWORK_TYPE")
    private String radioNetworkType;
    @CsvBindByName(column = "MOBILE_COUNTRY_CODE")
    private int mobileCountryCode;
    @CsvBindByName(column = "MOBILE_NETWORK_CODE")
    private int mobileNetworkCode;
    @CsvBindByName(column = "LOCATION_AREA_CODE")
    private int locationAreaCode;
    @CsvBindByName(column = "LONGITUDE")
    private float longitude;
    @CsvBindByName(column = "LATITUDE")
    private float latitute;
    @CsvBindByName(column = "CELL_RANGE")
    private int range;

    public int getMobileCountryCode() {
        return mobileCountryCode;
    }

    public void setMobileCountryCode(int mobileCountryCode) {
        this.mobileCountryCode = mobileCountryCode;
    }

    public int getMobileNetworkCode() {
        return mobileNetworkCode;
    }

    public void setMobileNetworkCode(int mobileNetworkCode) {
        this.mobileNetworkCode = mobileNetworkCode;
    }

    public int getLocationAreaCode() {
        return locationAreaCode;
    }

    public void setLocationAreaCode(int locationAreaCode) {
        this.locationAreaCode = locationAreaCode;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public float getLatitute() {
        return latitute;
    }

    public void setLatitute(float latitute) {
        this.latitute = latitute;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getRadioNetworkType() {
        return radioNetworkType;
    }

    public void setRadioNetworkType(String radioNetworkType) {
        this.radioNetworkType = radioNetworkType;
    }


}
