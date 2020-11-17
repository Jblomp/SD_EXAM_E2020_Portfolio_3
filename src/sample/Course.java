package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Course {

    private int ID;
    private Teacher teacher;
    private String name;
    private String timeOfYear;

    public Course(int ID, Teacher teacher, String name, String timeOfYear) {
        this.ID = ID;
        this.teacher = teacher;
        this.name = name;
        this.timeOfYear = timeOfYear;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeOfYear() {
        return timeOfYear;
    }

    public void setTimeOfYear(String timeOfYear) {
        this.timeOfYear = timeOfYear;
    }

    //private ObservableList<Student> enrolledStudents = FXCollections.observableArrayList();
}
