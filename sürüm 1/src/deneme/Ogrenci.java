
package deneme;

public class Ogrenci {
    private int ogrenci_no;
    private String ad;
    private int not;

    public Ogrenci(int ogrenci_no, String ad, int not) {
        this.ogrenci_no = ogrenci_no;
        this.ad = ad;
        this.not = not;
    }

    public int getOgrenci_no() {
        return ogrenci_no;
    }

    public void setOgrenci_no(int ogrenci_no) {
        this.ogrenci_no = ogrenci_no;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getNot() {
        return not;
    }

    public void setNot(int not) {
        this.not = not;
    }
    
}
