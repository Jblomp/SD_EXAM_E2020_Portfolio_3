package sample;

import java.sql.*;

public class QueryWriter {
    Connection conn = null;
    Statement stmt;
    private Student student;

    public void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }

    public void Connect(String url) throws SQLException {
        conn = DriverManager.getConnection(url);
    }

    public void CloseConnection() throws SQLException {
        conn.close();
    }

    public ResultSet SearchQueryStatement(String queryStatement) throws SQLException {
        ResultSet rs = stmt.executeQuery(queryStatement);
        //
        if (rs == null) System.out.println("No records retrieved");
        while (rs != null && rs.next()) {
            String name = rs.getString(1);
            int tracks = rs.getInt(2);
            System.out.println(name + " " + tracks);
        }
        return rs;
    }

    public ResultSet InputStatement() throws SQLException {


        ResultSet rs = stmt.executeQuery("1");
        if (rs == null)
            System.out.println("No records retrieved");
        while (rs != null && rs.next()) {
            int ID = rs.getInt(1);
            String FIRST_NAME = rs.getString(2);
            String LAST_NAME = rs.getString(3);
            String EMAIL = rs.getString(4);
            String PHONE = rs.getString(5);
            String CITY = rs.getString(6);
        }
        return rs;
    }

    public PreparedStatement PreparedStatementInsertStudent(Student student) throws SQLException {


        String pInputStatement = "INSERT INTO STUDENTS(ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE,CITY) VALUES("+student.getID()+", "
                +student.getFirstName()+", "
                +student.getLastName()+", "
                +student.getEmail()+", "
                +student.getPhoneNo()+", "
                +student.getCity()+");";
        System.out.println(pInputStatement);
        PreparedStatement pstmt = conn.prepareStatement(pInputStatement);

            pstmt.setInt(1, student.getID());
            pstmt.setString(2, student.getFirstName());
            pstmt.setString(3, student.getLastName());
            pstmt.setString(4, student.getEmail());
            pstmt.setString(5, student.getPhoneNo());
            pstmt.setString(6, student.getCity());


     return pstmt;
    }
}
