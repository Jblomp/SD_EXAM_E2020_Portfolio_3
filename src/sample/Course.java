package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Course {

    private StringProperty COURSEDB;
    private StringProperty TEACHERDB;
    private FloatProperty AVGGRADEDB;

    private int ID;
    private Teacher teacher;
    private String name;
    private String timeOfYear;

    public Course() {
        this.COURSEDB = new SimpleStringProperty();
        this.TEACHERDB = new SimpleStringProperty();
        this.AVGGRADEDB = new SimpleFloatProperty();
    }

    public Course(int ID, Teacher teacher, String name, String timeOfYear) {
        this.ID = ID;
        this.teacher = teacher;
        this.name = name;
        this.timeOfYear = timeOfYear;
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

    public float getAVGGRADEDB() {
        return AVGGRADEDB.get();
    }

    public FloatProperty AVGGRADEDBProperty() {
        return AVGGRADEDB;
    }

    public void setAVGGRADEDB(float AVGGRADEDB) {
        this.AVGGRADEDB.set(AVGGRADEDB);
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
