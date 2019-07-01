
package deneme;


public class lesson {
    private int lesson_no;
    private String lesson_name;
    private int class_no;

    public lesson(int lesson_no, String lesson_name, int class_no) {
        this.lesson_no = lesson_no;
        this.lesson_name = lesson_name;
        this.class_no = class_no;
    }

    public int getLesson_no() {
        return lesson_no;
    }

    public void setLesson_no(int lesson_no) {
        this.lesson_no = lesson_no;
    }

    public String getLesson_name() {
        return lesson_name;
    }

    public void setLesson_name(String lesson_name) {
        this.lesson_name = lesson_name;
    }

    public int getClass_no() {
        return class_no;
    }

    public void setClass_no(int class_no) {
        this.class_no = class_no;
    }
    
}
