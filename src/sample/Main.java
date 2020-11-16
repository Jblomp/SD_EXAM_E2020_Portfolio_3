package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Course, Student & Grades?");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
    QueryWriter QW =new QueryWriter();
        try{

        String url="jdbc:sqlite:C:/Users/JesperBlom/Desktop/Train.db";
        QW.Connect(url);
        //SQL station select select statement
//            Statement stmt=conn.createStatement();
        QW.createStatement();
        ResultSet rs=QW.StationQuerystmt();

        //   rs=TDB.StationInputStatement();
        rs=QW.sqlPlanPreparedStatement("Roskilde", "Odense", (float) 4.45);

        //          System.out.println(" Type station name you want info for:");
        //Statement stmt2=conn.createStatement();
        //          Scanner scanner = new Scanner(System.in);
        //         String Stationname=scanner.nextLine();

          /*  sql="SELECT * FROM station WHERE Name='"+Stationname+"';";
            rs = stmt.executeQuery(sql);
            if(rs==null)
                System.out.println("No records retrieved");
            while(rs!=null && rs.next()){
                String name=rs.getString(1);
                int tracks=rs.getInt(2);
                System.out.println(name +" "+tracks);
               }
*/
    }catch (
    SQLException e)
    {
        e.printStackTrace();
    }
        finally {
        if(QW.conn!=null)
        {
            try{
                QW.CloseConnection();
            }catch (SQLException d){
                d.printStackTrace();
            }
        }
    }
}
