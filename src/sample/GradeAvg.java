package sample;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class GradeAvg {
    private StringProperty STUDENTDB;
    private FloatProperty AVGGRADEDB;

    public GradeAvg() {
        this.STUDENTDB = new SimpleStringProperty();
        this.AVGGRADEDB = new SimpleFloatProperty();
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
