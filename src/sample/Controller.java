package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {

    public TableView tableStudents;
    public TableColumn tableColumnFirstName;
    public TableColumn tableColumnLastName;
    public TableColumn tableColumnStudentId;
    public ComboBox comboboxStudents;
    public ComboBox comboBoxCourses;
    public TextField textFieldPhone;
    public Button buttonAddNewStudent;
    public TextField textFieldEmail;
    public TextField textFieldCity;
    public ComboBox comboBoxList;
    public ComboBox comboboxStudentsToCourse;
    public Button buttonStudentToCourse;
    public ComboBox comboboxGradeToStudents;
    public ComboBox comboBoxGrades;
    public Button buttonAddGradeToStudent;
    public TextField DataSearch;
    public Button buttonSearchQuery;
    public TableColumn tableColumnEmail;
    public TableColumn tableColumnPhone;
    public TableColumn tableColumnCity;

    private QueryWriter queryWriter = new QueryWriter();

    ObservableList<Student> students = FXCollections.observableArrayList();
    ObservableList<Course> courses = FXCollections.observableArrayList();

    public TextField textFieldFirstName;
    public TextField textFieldLastName;

    int studentId = 10000;


    public void addStudent(ActionEvent actionEvent) {
        Student student = new Student(studentId, textFieldFirstName.getText(), textFieldLastName.getText(), textFieldEmail.getText(), textFieldPhone.getText(), textFieldCity.getText());
        studentId += 27;
        students.add(student);
        try {
            queryWriter.Connect("jdbc:sqlite:/Users/magnus/Desktop/student.DB");
            queryWriter.createStatement();
            queryWriter.PreparedStatementInsertStudent(student);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(students);
    }

    // will be executed when GUI is ready
    public void initialize()
    {
        tableStudents.setItems(students);

        tableColumnStudentId.setCellValueFactory(
                new PropertyValueFactory<Student, String>("ID")
        );
        tableColumnFirstName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("firstName")
        );
        tableColumnLastName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("lastName")
        );
        tableColumnEmail.setCellValueFactory(
                new PropertyValueFactory<Student, String>("email")
        );
        tableColumnPhone.setCellValueFactory(
            new PropertyValueFactory<Student, String>("phoneNo")
        );
        tableColumnCity.setCellValueFactory(
                new PropertyValueFactory<Student, String>("city")
        );


        comboboxStudentsToCourse.setItems(students);
        comboBoxCourses.setItems(courses);
        Teacher line = new Teacher(1,"Line", "Reinhardt");
        Teacher ebbe = new Teacher(2,"Ebbe", "Vang");

        courses.addAll(new Course(1, line,"SD","E2019" ), new Course(2, line,"SD","F2020"), new Course(3,ebbe,"ES1","F2020"));
    }

    public void AddStudentToCourse(ActionEvent actionEvent) {


        System.out.println(comboBoxCourses.getSelectionModel().getSelectedItem());
        System.out.println(comboboxStudents.getSelectionModel().getSelectedItem());
    }

    public void AddGradeToStudent(ActionEvent actionEvent) {
    }

    public void searchQuery(ActionEvent actionEvent) {
    }
}
