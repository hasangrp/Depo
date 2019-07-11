
package database;

public class Note {
    private int studentNumber;
    private int lessonNumber;
    private int note;

    public int getStudent_no() {
        return studentNumber;
    }

    public void setStudent_no(int student_no) {
        this.studentNumber = student_no;
    }

    public int getLesson_no() {
        return lessonNumber;
    }

    public void setLesson_no(int lesson_no) {
        this.lessonNumber = lesson_no;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

}
