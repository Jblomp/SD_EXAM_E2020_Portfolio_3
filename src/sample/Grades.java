package sample;

public class Grades {
    private int ID;
    private Teacher teacher;
    private Student student;
    private Course course;
    private int grade;

    public Grades(int ID, Teacher teacher, Student student, Course course, int grade) {
        this.ID = ID;
        this.teacher = teacher;
        this.student = student;
        this.course = course;
        this.grade = grade;
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
