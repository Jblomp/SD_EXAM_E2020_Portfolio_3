package sample;

public class Teacher {
    private int ID;
    private String firstName;
    private String lastName;

    public Teacher(int ID, String firstName, String lastName) {
        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
