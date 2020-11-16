package sample;

import java.sql.*;
import java.util.Scanner;

public class QueryWriter {
    Connection conn=null;
    Statement stmt;
    public void createStatement() throws SQLException {
        stmt = conn.createStatement();
    }
    public void Connect(String url) throws SQLException {
        conn= DriverManager.getConnection(url);
    }
    public void CloseConnection() throws SQLException{
        conn.close();
    }
    public ResultSet StationQuerystmt() throws SQLException{
        String sql="SELECT * FROM station;";
        ResultSet rs=stmt.executeQuery(sql);
        //
        if(rs==null) System.out.println("No records retrieved");
        while(rs!=null && rs.next()){
            String name=rs.getString(1);
            int tracks=rs.getInt(2);
            System.out.println(name +" "+tracks);
        }
        return rs;
    }
    public ResultSet StationInputStatement() throws  SQLException{

        Scanner scanner = new Scanner(System.in);
        System.out.println(" Type station name you want info for:");
        String Stationname = scanner.nextLine();

        String sql = "SELECT * FROM station WHERE Name='" + Stationname + "';";
        ResultSet rs = stmt.executeQuery(sql);
        if (rs == null)
            System.out.println("No records retrieved");
        while (rs != null && rs.next()) {
            String name = rs.getString(1);
            int tracks = rs.getInt(2);
            System.out.println(name + " " + tracks);
        }
        return rs;
    }

    public ResultSet sqlPlanPreparedStatement(String FromStation, String ToStation, float time) throws SQLException{
        String sql = "SELECT D1.TrainID, D1.StationName, D1.Time, D2.StationName, D2.Time " +
                "FROM Departure as D1 " +
                "JOIN Departure as D2 on D1.TrainID=D2.TrainID " +
                "WHERE D1.StationName= ? AND D2.StationName= ? AND D1.Time > ? "
                + " AND D1.Time< D2.Time;";
        PreparedStatement pstmt=conn.prepareStatement(sql);
        pstmt.setString(1, FromStation);
        pstmt.setString(2,ToStation);
        pstmt.setFloat(3,time);
        ResultSet rs= pstmt.executeQuery();
        if(rs==null)
            System.out.println("No records retrieved");
        while(rs!=null && rs.next()){
            System.out.println(rs.getInt(1)+ " "+ rs.getString(2)+ " " + rs.getFloat(3) +
                    " "+ rs.getString(4) + " "+rs.getFloat(5));
        }
        return rs;
    }
}
