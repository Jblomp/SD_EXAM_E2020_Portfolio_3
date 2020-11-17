package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {

    private IntegerProperty IDDB;
    private StringProperty firstNameDB;
    private StringProperty lastNameDB;
    private StringProperty emailDB;
    private StringProperty phoneNoDB;
    private StringProperty cityDB;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String city;


    public Student(String firstName, String lastName, String email, String phoneNo, String city){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNo = phoneNo;
        this.city = city;
    };

    public Student() {
        this.IDDB = new SimpleIntegerProperty();
        this.firstNameDB = new SimpleStringProperty();
        this.lastNameDB = new SimpleStringProperty();
        this.emailDB = new SimpleStringProperty();
        this.phoneNoDB = new SimpleStringProperty();
        this.cityDB = new SimpleStringProperty();
    }

    public int getIDDB() {
        return IDDB.get();
    }

    public IntegerProperty IDDBProperty() {
        return IDDB;
    }

    public void setIDDB(int IDDB) {
        this.IDDB.set(IDDB);
    }

    public String getFirstNameDB() {
        return firstNameDB.get();
    }

    public StringProperty firstNameDBProperty() {
        return firstNameDB;
    }

    public void setFirstNameDB(String firstNameDB) {
        this.firstNameDB.set(firstNameDB);
    }

    public String getLastNameDB() {
        return lastNameDB.get();
    }

    public StringProperty lastNameDBProperty() {
        return lastNameDB;
    }

    public void setLastNameDB(String lastNameDB) {
        this.lastNameDB.set(lastNameDB);
    }

    public String getEmailDB() {
        return emailDB.get();
    }

    public StringProperty emailDBProperty() {
        return emailDB;
    }

    public void setEmailDB(String emailDB) {
        this.emailDB.set(emailDB);
    }

    public String getPhoneNoDB() {
        return phoneNoDB.get();
    }

    public StringProperty phoneNoDBProperty() {
        return phoneNoDB;
    }

    public void setPhoneNoDB(String phoneNoDB) {
        this.phoneNoDB.set(phoneNoDB);
    }

    public String getCityDB() {
        return cityDB.get();
    }

    public StringProperty cityDBProperty() {
        return cityDB;
    }

    public void setCityDB(String cityDB) {
        this.cityDB.set(cityDB);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
