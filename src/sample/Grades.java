package sample;

import javafx.beans.property.*;

public class Grades {
    private StringProperty STUDENTDB;
    private StringProperty COURSEDB;
    private StringProperty TEACHERDB;
    private IntegerProperty GRADEDB;


    private int ID;
    private Teacher teacher;
    private Student student;
    private Course course;
    private int grade;

    public Grades() {
        this.STUDENTDB = new SimpleStringProperty();
        this.COURSEDB = new SimpleStringProperty();
        this.TEACHERDB = new SimpleStringProperty();
        this.GRADEDB = new SimpleIntegerProperty();
    }

    public Grades(int ID, Teacher teacher, Student student, Course course, int grade) {
        this.ID = ID;
        this.teacher = teacher;
        this.student = student;
        this.course = course;
        this.grade = grade;
    }

    public String getSTUDENTDB() {
        return STUDENTDB.get();
    }

    public StringProperty STUDENTDBProperty() {
        return STUDENTDB;
    }

    public void setSTUDENTDB(String STUDENTDB) {
        this.STUDENTDB.set(STUDENTDB);
    }

    public String getCOURSEDB() {
        return COURSEDB.get();
    }

    public StringProperty COURSEDBProperty() {
        return COURSEDB;
    }

    public void setCOURSEDB(String COURSEDB) {
        this.COURSEDB.set(COURSEDB);
    }

    public String getTEACHERDB() {
        return TEACHERDB.get();
    }

    public StringProperty TEACHERDBProperty() {
        return TEACHERDB;
    }

    public void setTEACHERDB(String TEACHERDB) {
        this.TEACHERDB.set(TEACHERDB);
    }

    public int getGRADEDB() {
        return GRADEDB.get();
    }

    public IntegerProperty GRADEDBProperty() {
        return GRADEDB;
    }

    public void setGRADEDB(int GRADEDB) {
        this.GRADEDB.set(GRADEDB);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
