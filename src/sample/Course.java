package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Course {

    private StringProperty COURSEDB;
    private StringProperty TEACHERDB;
    private FloatProperty AVGGRADEDB;

    public Course() {
        this.COURSEDB = new SimpleStringProperty();
        this.TEACHERDB = new SimpleStringProperty();
        this.AVGGRADEDB = new SimpleFloatProperty();
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

}
