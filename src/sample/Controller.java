package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;

public class Controller {

    public TableView tableStudents;
    public TableColumn<Student, String> tableColumnFirstName;
    public TableColumn<Student, String> tableColumnLastName;
    public TableColumn<Student, String> tableColumnStudentId;
    public TableColumn<Student, String> tableColumnEmail;
    public TableColumn<Student, String> tableColumnPhone;
    public TableColumn<Student, String> tableColumnCity;
    public ComboBox comboboxStudents;
    public ComboBox<Course> comboBoxCourses;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldEmail;
    public TextField textFieldPhone;
    public TextField textFieldCity;
    public TextField DataSearch;
    public ComboBox comboBoxList;
    public ComboBox comboboxStudentsToCourse;
    public ComboBox comboboxGradeToStudents;
    public ComboBox comboBoxGrades;
    public Button buttonSearchQuery;
    public Button buttonAddNewStudent;
    public Button buttonStudentToCourse;
    public Button buttonAddGradeToStudent;

    private QueryWriter queryWriter = new QueryWriter();



    private static Connection conn;
    private static Statement stmt;

    // will be executed when GUI is ready
    private ObservableList<Student> studentList;
    public void initialize() throws SQLException, ClassNotFoundException {
        studentList = FXCollections.observableArrayList();

        tableColumnStudentId.setCellValueFactory(
                new PropertyValueFactory<Student, String>("IDDB")
        );
        tableColumnFirstName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("firstNameDB")
        );
        tableColumnLastName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("lastNameDB")
        );
        tableColumnEmail.setCellValueFactory(
                new PropertyValueFactory<Student, String>("emailDB")
        );
        tableColumnPhone.setCellValueFactory(
                new PropertyValueFactory<Student, String>("phoneNoDB")
        );
        tableColumnCity.setCellValueFactory(
                new PropertyValueFactory<Student, String>("cityDB")
        );
        String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Desktop\\Project.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                Student student = new Student();
                student.setIDDB(rs.getInt("ID"));
                student.setFirstNameDB(rs.getString("FIRST_NAME"));
                student.setLastNameDB(rs.getString("LAST_NAME"));
                student.setEmailDB(rs.getString("EMAIL"));
                student.setPhoneNoDB(rs.getString("PHONE"));
                student.setCityDB(rs.getString("CITY"));
                studentList.add(student);
            }
            tableStudents.setItems(studentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void updateTableViews(ObservableList listToUpdate) throws SQLException {
        studentList.clear();
        String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Desktop\\Project.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                Student student = new Student();
                student.setIDDB(rs.getInt("ID"));
                student.setFirstNameDB(rs.getString("FIRST_NAME"));
                student.setLastNameDB(rs.getString("LAST_NAME"));
                student.setEmailDB(rs.getString("EMAIL"));
                student.setPhoneNoDB(rs.getString("PHONE"));
                student.setCityDB(rs.getString("CITY"));
                studentList.add(student);
            }
            tableStudents.setItems(studentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    };


    public void preparedStatementExecute(Student student) throws SQLException {
        String url = "jdbc:sqlite:C:\\Users\\JesperBlom\\Desktop\\Project.db";
        try {
            queryWriter.Connect(url);
            queryWriter.createStatement();
            queryWriter.PreparedStatementInsertStudent(student);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        updateTableViews(studentList);
    }

    public void addStudent(ActionEvent actionEvent) throws SQLException {
        Student student = new Student(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldEmail.getText(),textFieldPhone.getText(),textFieldCity.getText());
        preparedStatementExecute(student);
    }
    public void AddStudentToCourse(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        System.out.println(comboBoxCourses.getSelectionModel().getSelectedItem());
        System.out.println(comboboxStudents.getSelectionModel().getSelectedItem());
    }

    public void AddGradeToStudent(ActionEvent actionEvent) {
    }

    public void searchQuery(ActionEvent actionEvent) {
    }
}
