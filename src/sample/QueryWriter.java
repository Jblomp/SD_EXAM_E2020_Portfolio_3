package sample;

import java.sql.*;

public class QueryWriter {
    Connection conn = null;
    Statement stmt;

    public void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public void Connect(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void PreparedStatementInsertStudent(Student student) throws SQLException {
        PreparedStatement pInputStatement = conn.prepareStatement("INSERT INTO STUDENTS(ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE,CITY) VALUES(null,'"
                +student.getFirstName()+"', '"
                +student.getLastName()+"', '"
                +student.getEmail()+"', '"
                +student.getPhoneNo()+"', '"
                +student.getCity()+"');"
        );
        pInputStatement.executeUpdate();
    }

    public void PreparedStatementInsertGrades(String student, String Course) throws SQLException {
        PreparedStatement pInputStatement = conn.prepareStatement(
                "INSERT INTO GRADES SELECT NULL, STUDENTS.ID, COURSES.ID, COURSES.TEACHER_ID, NULL " +
                     "FROM STUDENTS, COURSES " +
                     "WHERE STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME = '"+student+"' " +
                     "AND COURSES.NAME ||' '|| TIME_OF_YEAR = '"+Course+"';"
        );

        pInputStatement.executeUpdate();


    }

    public void PreparedStatementUpdateGrades(int studentID, int courseID, int grade) throws SQLException {
        PreparedStatement pInputStatement = conn.prepareStatement(
                "UPDATE GRADES SET GRADE = '"+grade+"' " +
                     "WHERE STUDENT_ID = '"+studentID+"' " +
                     "AND COURSE_ID = '"+courseID+"' " +
                     "AND GRADE IS NULL;"
        );
        pInputStatement.executeUpdate();

    }

}
