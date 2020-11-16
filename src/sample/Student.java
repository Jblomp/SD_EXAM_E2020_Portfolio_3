package sample;

public class Student {
    private String firstname;
    private String lastname;
    private String studentID;

    public Student(String firstname, String lastname, String studentID) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.studentID = studentID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        if (firstname.length()< 20 && firstname.length() > 1)
            this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String info() {
        return "Student{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", studentID='" + studentID + '\'' +
                '}';
    }

    @Override
    public String toString() {
        return firstname + " " + lastname;
    }
}
