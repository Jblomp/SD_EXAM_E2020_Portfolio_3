package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    public TableView tableStudents;
    public TableColumn tableColumnFirstName;
    public TableColumn tableColumnLastName;
    public TableColumn tableColumnStudentId;
    public ComboBox comboboxStudents;
    public ComboBox comboBoxCourses;

    ObservableList<Student> students = FXCollections.observableArrayList();
    ObservableList<Course> courses = FXCollections.observableArrayList();

    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldStudentId;

    public void addStudent(ActionEvent actionEvent) {
        Student student = new Student(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldStudentId.getText());
        students.add(student);

        System.out.println(students);
    }

    // will be executed when GUI is ready
    public void initialize()
    {
        tableStudents.setItems(students);

        tableColumnFirstName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("firstname")
        );
        tableColumnLastName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("lastname")
        );
        tableColumnStudentId.setCellValueFactory(
                new PropertyValueFactory<Student, String>("studentID")
        );

        comboboxStudents.setItems(students);
        comboBoxCourses.setItems(courses);

        courses.addAll(new Course("IDS"), new Course("SD"));
    }

    public void AddStrudentToCourse(ActionEvent actionEvent) {
        System.out.println(comboBoxCourses.getSelectionModel().getSelectedItem());
        System.out.println(comboboxStudents.getSelectionModel().getSelectedItem());
    }
}
