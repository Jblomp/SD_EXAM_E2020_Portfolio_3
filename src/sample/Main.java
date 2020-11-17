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
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Course, Student & Grades?");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);


        QueryWriter QW = new QueryWriter();

        String url = "jdbc:sqlite:C:/Users/JesperBlom/Desktop/Train.db";
        try {
            QW.Connect(url);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (QW.conn != null) {
                try {
                    QW.CloseConnection();
                } catch (SQLException d) {
                    d.printStackTrace();
                }
            }
        }
    }
}


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
