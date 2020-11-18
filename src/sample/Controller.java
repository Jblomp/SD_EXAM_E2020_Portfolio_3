package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.print.DocFlavor;
import java.sql.*;
import java.util.Set;

public class Controller {
    //observablelists ues for comboboxes and tableviews
    private ObservableList<Student> studentList;
    private ObservableList<Grades> studentAllCourses;
    private ObservableList<GradeAvg> studentAvgGrade;
    private ObservableList<Course> courseAvgGrade;
    private ObservableList studentsForComboBox;
    private ObservableList coursesForComboBox;
    private ObservableList studentsForGradesComboBox;
    private ObservableList coursesForGradesComboBox;
    private ObservableList gradesForCombox;

    //studentList tab variables in GUI
    public TableView tableStudents;
    public TableColumn<Student, String> tableColumnFirstName;
    public TableColumn<Student, String> tableColumnLastName;
    public TableColumn<Student, String> tableColumnStudentId;
    public TableColumn<Student, String> tableColumnEmail;
    public TableColumn<Student, String> tableColumnPhone;
    public TableColumn<Student, String> tableColumnCity;
    public TextField textFieldFirstName;
    public TextField textFieldLastName;
    public TextField textFieldEmail;
    public TextField textFieldPhone;
    public TextField textFieldCity;
    public Button buttonAddNewStudent;

    //Info variables in GUI
    public TableView tableStudentAllCourses;
    public TableColumn tableColumnStudentName;
    public TableColumn tableColumnStudentCourse;
    public TableColumn tableColumnStudentTeacher;
    public TableColumn tableColumnStudentGrade;
    public Button buttonGetStudentCourses;
    public ComboBox comboboxStudentsInfoTab1 = new ComboBox(studentsForComboBox);;

    public TableView tableStudentAverageGrade;
    public TableColumn tableColumnStudentNameAverage;
    public TableColumn tableColumnStudentAverageGrade;
    public ComboBox comboboxStudentInfoTab2 = new ComboBox(studentsForComboBox);;
    public Button buttonGetAverageForStudent;

    public TableView tableCourseAverageGrade;
    public TableColumn tableColumnCourseFullName;
    public TableColumn tableColumnCourseTeacherFullNameInfo;
    public TableColumn tableColumnCourseAverageGrade;
    public Button buttonGetAverageForCourse;
    public ComboBox comboboxCourseInfoTab = new ComboBox(coursesForComboBox);

    //add student to course tab variables in GUI
    public Button buttonStudentToCourse;
    public ComboBox comboboxStudentToCourse = new ComboBox(studentsForComboBox);
    public ComboBox comboBoxAssignCourse = new ComboBox(coursesForComboBox);

    //add grade to student tab variables in GUI
    public Button buttonAddGradeToStudent;
    public ComboBox comboBoxGradesToStudent = new ComboBox(gradesForCombox);
    public ComboBox comboboxStudentsGrades = new ComboBox(studentsForGradesComboBox);
    public ComboBox comboboxCourseGrades = new ComboBox(coursesForGradesComboBox);

    //Instance of object: QueryWriter
    private QueryWriter queryWriter = new QueryWriter();

    public String dataBaseURL = "jdbc:sqlite:C:/Users/JesperBlom/Documents/RUC/SOFTWAREDEVELOPMENT/SD_EXAM_E2020_Portfolio3/Project.db";


    public void initialize() throws SQLException, ClassNotFoundException {
        studentList = FXCollections.observableArrayList();
        studentsForComboBox = FXCollections.observableArrayList();
        coursesForComboBox = FXCollections.observableArrayList();
        gradesForCombox = FXCollections.observableArrayList();
        studentsForGradesComboBox = FXCollections.observableArrayList();
        coursesForGradesComboBox = FXCollections.observableArrayList();
        studentAllCourses = FXCollections.observableArrayList();
        studentAvgGrade = FXCollections.observableArrayList();
        courseAvgGrade = FXCollections.observableArrayList();

        //Tableview Columns for tableCourseAverageGrade which displays all courses a student is added 2
        tableColumnStudentName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("STUDENTDB")
        );
        tableColumnStudentCourse.setCellValueFactory(
                new PropertyValueFactory<Student, String>("COURSEDB")
        );
        tableColumnStudentTeacher.setCellValueFactory(
                new PropertyValueFactory<Student, String>("TEACHERDB")
        );
        tableColumnStudentGrade.setCellValueFactory(
                new PropertyValueFactory<Student, String>("GRADEDB")
        );


        //Tableview Columns for tableStudentAverageGrade which displays avg grade for a student
        tableColumnStudentNameAverage.setCellValueFactory(
                new PropertyValueFactory<Student, String>("STUDENTDB")
        );
        tableColumnStudentAverageGrade.setCellValueFactory(
                new PropertyValueFactory<Student, String>("AVGGRADEDB")
        );

        //Tableview Columns for tableStudentAverageGrade which displays avg grade for a course
        tableColumnCourseFullName.setCellValueFactory(
                new PropertyValueFactory<Student, String>("COURSEDB")
        );
        tableColumnCourseTeacherFullNameInfo.setCellValueFactory(
                new PropertyValueFactory<Student, String>("TEACHERDB")
        );
        tableColumnCourseAverageGrade.setCellValueFactory(
                new PropertyValueFactory<Student, String>("AVGGRADEDB")
        );


        //Tableview Columns for tableStudents which display all students
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

        //populate comboboxes and tableviews when GUI starts
        comboBoxGradesToStudent.setItems(gradesForCombox);
        gradesForCombox.addAll(-3, 0,2,4,7,10,12);
        populateComboBoxStudents();
        populateComboBoxCourses();
        populateComboBoxGradesToStudentStudent();
        populateComboBoxGradesToStudentCourse();
        populateTableStudents();

    }

    private void populateTableStudents() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENTS");
            while (rs.next()) {
                Student student = new Student();
                student.setIDDB(rs.getInt("ID"));
                student.setFirstNameDB(rs.getString("FIRST_NAME"));
                student.setLastNameDB(rs.getString("LAST_NAME"));
                student.setEmailDB(rs.getString("EMAIL"));
                student.setPhoneNoDB(rs.getString("PHONE"));
                student.setCityDB(rs.getString("CITY"));
                //add student 'line' from STUDENTS to an observablelist
                studentList.add(student);
            }
            //set tableview = the observablelist
            tableStudents.setItems(studentList);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateTableStudentAllCourses(String student) throws SQLException {
        studentAllCourses.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME AS [STUDENTDB], COURSES.NAME ||' '|| COURSES.TIME_OF_YEAR AS [COURSEDB], TEACHERS.FIRST_NAME ||' '|| TEACHERS.LAST_NAME AS [TEACHERDB], GRADE GRADEDB FROM GRADES LEFT JOIN STUDENTS on GRADES.STUDENT_ID = STUDENTS.ID LEFT JOIN COURSES on GRADES.COURSE_ID = COURSES.ID LEFT JOIN TEACHERS on COURSES.TEACHER_ID = TEACHERS.ID WHERE STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME = '"+student+"' ;");
            while (rs.next()) {
                Grades grade = new Grades();
                grade.setSTUDENTDB(rs.getString("STUDENTDB"));
                grade.setCOURSEDB(rs.getString("COURSEDB"));
                grade.setTEACHERDB(rs.getString("TEACHERDB"));
                grade.setGRADEDB(rs.getInt("GRADEDB"));
                studentAllCourses.add(grade);
            }
            tableStudentAllCourses.setItems(studentAllCourses);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateTableStudentAvgGrade(String student) throws SQLException {
        studentAvgGrade.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME AS [STUDENTDB], AVG(DISTINCT GRADE)AS AVGGRADEDB FROM GRADES LEFT JOIN STUDENTS on GRADES.STUDENT_ID = STUDENTS.ID WHERE STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME = '"+student+"' GROUP BY STUDENT_ID");
            while (rs.next()) {
                GradeAvg gradeavg = new GradeAvg();
                gradeavg.setSTUDENTDB(rs.getString("STUDENTDB"));
                gradeavg.setAVGGRADEDB(rs.getFloat("AVGGRADEDB"));
                studentAvgGrade.add(gradeavg);
            }
            tableStudentAverageGrade.setItems(studentAvgGrade);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateTableCourseAvgGrade(String course) throws SQLException {
        courseAvgGrade.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT COURSES.NAME ||' '|| COURSES.TIME_OF_YEAR AS [COURSEDB], TEACHERS.FIRST_NAME ||' '|| TEACHERS.LAST_NAME AS [TEACHERDB], AVG(DISTINCT GRADE) AS AVGGRADEDB FROM GRADES LEFT JOIN COURSES on GRADES.COURSE_ID = COURSES.ID LEFT JOIN TEACHERS on COURSES.TEACHER_ID = TEACHERS.ID WHERE COURSES.NAME ||' '|| COURSES.TIME_OF_YEAR = '"+ course+"'");
            while (rs.next()) {
                Course courseobj = new Course();
                courseobj.setCOURSEDB(rs.getString("COURSEDB"));
                courseobj.setTEACHERDB(rs.getString("TEACHERDB"));
                courseobj.setAVGGRADEDB(rs.getFloat("AVGGRADEDB"));
                courseAvgGrade.add(courseobj);
            }
            tableCourseAverageGrade.setItems(courseAvgGrade);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateComboBoxGradesToStudentStudent() throws SQLException{
        studentsForGradesComboBox.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT S.FIRST_NAME ||' '|| S.LAST_NAME AS NAME FROM GRADES LEFT JOIN STUDENTS S ON GRADES.STUDENT_ID = S.ID WHERE GRADE IS NULL GROUP BY STUDENT_ID;");
            while (rs.next()) {
                studentsForGradesComboBox.add(rs.getString("NAME"));
            }
            comboboxStudentsGrades.setItems(studentsForGradesComboBox);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateComboBoxGradesToStudentCourse() throws SQLException{
        coursesForGradesComboBox.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT NAME ||' '|| TIME_OF_YEAR AS NAME FROM GRADES LEFT JOIN COURSES ON GRADES.COURSE_ID = COURSES.ID WHERE GRADE IS NULL GROUP BY COURSE_ID");
            while (rs.next()) {
                coursesForGradesComboBox.add(rs.getString("NAME"));
            }
            comboboxCourseGrades.setItems(coursesForGradesComboBox);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    private void populateComboBoxStudents() throws SQLException{
        studentsForComboBox.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT FIRST_NAME ||' '|| LAST_NAME AS NAME FROM STUDENTS");
            while (rs.next()) {
                studentsForComboBox.add(rs.getString("NAME"));
            }
            comboboxStudentToCourse.setItems(studentsForComboBox);
            comboboxStudentsInfoTab1.setItems(studentsForComboBox);
            comboboxStudentInfoTab2.setItems(studentsForComboBox);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void populateComboBoxCourses() throws SQLException{
        coursesForComboBox.clear();
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT NAME ||' '|| TIME_OF_YEAR AS NAME FROM COURSES");
            while (rs.next()) {
                coursesForComboBox.add(rs.getString("NAME"));
            }
            comboBoxAssignCourse.setItems(coursesForComboBox);
            comboboxCourseInfoTab.setItems(coursesForComboBox);
            } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public void addStudent(ActionEvent actionEvent) throws SQLException {
        Student student = new Student(textFieldFirstName.getText(), textFieldLastName.getText(), textFieldEmail.getText(),textFieldPhone.getText(),textFieldCity.getText());
        try {
            queryWriter.Connect(dataBaseURL);
            queryWriter.createStatement();
            queryWriter.PreparedStatementInsertStudent(student);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        studentList.clear();
        studentsForComboBox.clear();
        populateComboBoxStudents();
        populateTableStudents();
    }

    public void AddStudentToCourse(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        try {
            queryWriter.Connect(dataBaseURL);
            queryWriter.createStatement();
            queryWriter.PreparedStatementInsertGrades((String)comboboxStudentToCourse.getSelectionModel().getSelectedItem(), (String)comboBoxAssignCourse.getSelectionModel().getSelectedItem());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        populateComboBoxGradesToStudentStudent();
        populateComboBoxGradesToStudentCourse();
    }

    public void AddGradeToStudent(ActionEvent actionEvent) throws SQLException {
        int studentID = 0;
        int courseID = 0;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM STUDENTS WHERE STUDENTS.FIRST_NAME ||' '|| STUDENTS.LAST_NAME = '"+comboboxStudentsGrades.getSelectionModel().getSelectedItem()+"'");
            while (rs.next()) {
                studentID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        try {
            conn = DriverManager.getConnection(dataBaseURL);
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM COURSES WHERE COURSES.NAME ||' '|| COURSES.TIME_OF_YEAR = '"+comboboxCourseGrades.getSelectionModel().getSelectedItem()+"'");
            while (rs.next()) {
                courseID = rs.getInt("ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        try {
            queryWriter.Connect(dataBaseURL);
            queryWriter.createStatement();
            queryWriter.PreparedStatementUpdateGrades(studentID, courseID, (int) comboBoxGradesToStudent.getSelectionModel().getSelectedItem());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getStudentCourses(ActionEvent actionEvent) throws SQLException {
        populateTableStudentAllCourses((String)comboboxStudentsInfoTab1.getSelectionModel().getSelectedItem());
    }

    public void getAverageForStudent(ActionEvent actionEvent) throws SQLException {
    populateTableStudentAvgGrade((String)comboboxStudentInfoTab2.getSelectionModel().getSelectedItem());
    }

    public void getAverageForCourse(ActionEvent actionEvent) throws SQLException {
        populateTableCourseAvgGrade((String)comboboxCourseInfoTab.getSelectionModel().getSelectedItem());
    }

}
