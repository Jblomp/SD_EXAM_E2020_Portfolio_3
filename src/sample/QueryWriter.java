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

    public ResultSet InputStatement(String inputStatement) throws SQLException {

        ResultSet rs = stmt.executeQuery(inputStatement);
        if (rs == null)
            System.out.println("No records retrieved");
        while (rs != null && rs.next()) {
            String name = rs.getString(1);
            int tracks = rs.getInt(2);
        }
        return rs;
    }

    public ResultSet CalculateAverage(String calculateStatement) throws SQLException {

        ResultSet rs = stmt.executeQuery(calculateStatement);
        if (rs == null)
            System.out.println("No records retrieved");
        while (rs != null && rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getFloat(3) +
                    " " + rs.getString(4) + " " + rs.getFloat(5));
        }
        return rs;
    }
}
