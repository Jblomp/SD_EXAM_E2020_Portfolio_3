package sample;

import javafx.beans.property.*;

public class Grades {
    private StringProperty STUDENTDB;
    private StringProperty COURSEDB;
    private StringProperty TEACHERDB;
    private IntegerProperty GRADEDB;

    public Grades() {
        this.STUDENTDB = new SimpleStringProperty();
        this.COURSEDB = new SimpleStringProperty();
        this.TEACHERDB = new SimpleStringProperty();
        this.GRADEDB = new SimpleIntegerProperty();
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

}
