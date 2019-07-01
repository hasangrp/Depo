
package deneme;

public class Student {
    private int ogrenci_no;
    private String ad;
    private int not;
    private int lesson_no;

    public Student(int ogrenci_no, String ad, int not, int lesson_no) {
        this.ogrenci_no = ogrenci_no;
        this.ad = ad;
        this.not = not;
        this.lesson_no = lesson_no;
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
    
    public int getLesson_no() {
        return lesson_no;
    }

    public void setLesson_no(int lesson_no) {
        this.lesson_no = lesson_no;
    }
    
}
