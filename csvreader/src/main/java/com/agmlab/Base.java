package com.agmlab;

public abstract class Base {

    private String radioNetworkType;
    private int mobileCountryCode;
    private int mobileNetworkCode;
    private int locationAreaCode;
    private double longitude;
    private double latitude;
    private int cellRange;

    public String getRadioNetworkType() {
        return radioNetworkType;
    }

    public void setRadioNetworkType(String radioNetworkType) {
        this.radioNetworkType = radioNetworkType;
    }

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

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longtitude) {
        this.longitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getCellRange() {
        return cellRange;
    }

    public void setCellRange(int cellRange) {
        this.cellRange = cellRange;
    }

    @Override
    public String toString(){
        final String s = "RADIO_NETWORK_TYPE : " + getRadioNetworkType() + "\n"
                + "MOBILE_COUNTRY_CODE : " + getMobileCountryCode() + "\n"
                + "MOBILE_NETWORK_CODE : " + getMobileNetworkCode() + "\n"
                + "LOCATION_AREA_CODE : " + getLocationAreaCode() + "\n"
                + "LONGITUDE : " + getLongitude() + "\n"
                + "LATITUDE : " + getLatitude() + "\n"
                + "CELL_RANGE : " + getCellRange() + "\n"
                + "------------------------------------------";
        return s;
    }
}
