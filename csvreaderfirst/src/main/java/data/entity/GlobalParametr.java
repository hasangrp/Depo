package data.entity;

import com.opencsv.bean.CsvBindByName;


public class GlobalParametr {
    @CsvBindByName(column = "radio")
    private String radio;
    @CsvBindByName(column = "mcc")
    private int mcc;
    @CsvBindByName(column = "net")
    private int net;
    @CsvBindByName(column = "area")
    private int area;
    @CsvBindByName(column = "cell")
    private int cell;
    @CsvBindByName(column = "unit")
    private int unit;
    @CsvBindByName(column = "lon")
    private float lon;
    @CsvBindByName(column = "lat")
    private float lat;
    @CsvBindByName(column = "range")
    private int globalRange;
    @CsvBindByName(column = "samples")
    private int samples;
    @CsvBindByName(column = "changeable")
    private int changeable;
    @CsvBindByName(column = "created")
    private int created;
    @CsvBindByName(column = "updated")
    private int updated;
    @CsvBindByName(column = "averageSignal")
    private int avarageSignal;

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public String getRadio() {
        return radio;
    }

    public void setRadio(String radio) {
        this.radio = radio;
    }

    public int getMcc() {
        return mcc;
    }

    public void setMcc(int mcc) {
        this.mcc = mcc;
    }

    public int getNet() {
        return net;
    }

    public void setNet(int net) {
        this.net = net;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getCell() {
        return cell;
    }

    public void setCell(int cell) {
        this.cell = cell;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLan() {
        return lat;
    }

    public void setLan(float lan) {
        this.lat = lan;
    }

    public int getGlobalRange() {
        return globalRange;
    }

    public void setGlobalRange(int globalRange) {
        this.globalRange = globalRange;
    }

    public int getSamples() {
        return samples;
    }

    public void setSamples(int samples) {
        this.samples = samples;
    }

    public int getChangeable() {
        return changeable;
    }

    public void setChangeable(int changeable) {
        this.changeable = changeable;
    }

    public int getUpdated() {
        return updated;
    }

    public void setUpdated(int updated) {
        this.updated = updated;
    }

    public int getAvarageSignal() {
        return avarageSignal;
    }

    public void setAvarageSignal(int avarageSignal) {
        this.avarageSignal = avarageSignal;
    }
    
}
