package View;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Region;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import java.io.FileNotFoundException;

public class AddController
{

  public ComboBox courseField;
  public ComboBox groupField;
  public TextField examinerField;
  public TextField timeEnd;
  public TextField timeStart;
  public ComboBox typeField;
  public Label errorLabel;
  private RoomList roomList;

  public ComboBox<String> semesterField;
  public DatePicker dateField;
  public DatePicker dateField2;
  public ComboBox<String> roomField;
  private Region root;
  private ManageExamModel model;
  private ViewHandler viewHandler;
  private ManageExamFiles files;
  public AddController(){}

  public void init(ViewHandler viewHandler, ManageExamModel model ,Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    files = new ManageExamFiles();
    reset();
  }

  public void reset() {
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void cancel() throws FileNotFoundException
  {
    viewHandler.openView("landing");
  }

  public void addExam(ActionEvent actionEvent) throws FileNotFoundException {
  int semesterS = Integer.parseInt(semesterField.getSelectionModel().getSelectedItem().toString());
  String courseS = courseField.getSelectionModel().getSelectedItem().toString();
  String groupS = groupField.getSelectionModel().getSelectedItem().toString();
  String[] examiners = examinerField.getText().split(", ",2);
  String examinerS = examiners[0];
  String roomS = roomField.getSelectionModel().getSelectedItem().toString();
  String typeS = typeField.getSelectionModel().getSelectedItem().toString();

  DateInterval dateInterval = getDateInterval();
  boolean hdmi = false;
  boolean vga = false;
  int chairs = 0;
  int table = 0;
  files.readRoomList();
  for(int i=0;i<files.getRoomList().getRoomList().size();i++)
  {
    if(files.getRoomList().getRoomList().get(i).getNumber().equals(roomS))
    {
      hdmi = files.getRoomList().getRoomList().get(i).isHDMI();
      vga = files.getRoomList().getRoomList().get(i).isVGA();
      table = files.getRoomList().getRoomList().get(i).getTables();
      chairs = files.getRoomList().getRoomList().get(i).getChairs();
    }
  }
  Room room = new Room(hdmi, vga, chairs, table, roomS);
  Group group = new Group(groupS, model.getNumberOfStudentsByGroupAndSemester(groupS,semesterS), semesterS);
  Examiner examiner = new Examiner(examinerS);
  Examiner teacher = new Examiner(model.getTeacherByCourseAndGroup(courseS,groupS).getName());
  Course course = new Course(teacher, courseS);

  Exam exam = new Exam(dateInterval, room, group, typeS, examiner, course);
  try{
    errorLabel.setText("");
    System.out.println(getDateStart().toString());
    model.validateExam(exam);
    ManageExamFiles files = new ManageExamFiles();
    files.AddExamList(exam);
    viewHandler.openView("landing");
  }catch (Exception e)
  {
   // System.out.println(e.getMessage());
    errorLabel.setText("");
    errorLabel.setText(e.getMessage());
  }




    //Todo: get selections from lists and then create a test Exam
  }

  //Room Management


  public void initializeGroup() throws FileNotFoundException
  {



  }

  @FXML
  public void initialize() throws FileNotFoundException
  {
    //Init Room Dropdown
    roomList = new RoomList(); //Todo: getRoomList from file instead
    roomField.getItems().removeAll(roomField.getItems());
    roomField.getItems().add("----Add Room----");
    roomField.getSelectionModel().select("----Add Room----");
    files = new ManageExamFiles();
    files.readRoomList();
    for (int i = 0; i < files.getRoomList().getRoomList().size(); i++) {
      //if(model.isRoomTaken(files.getRoomList().getRoomList().get(i),dateInterval))
      roomField.getItems().add(files.getRoomList().getRoomList().get(i).getNumber());
    }
    ///Init Type Dropdown
    typeField.getItems().removeAll(typeField.getItems());
    typeField.getItems().addAll("Oral","Written");
    typeField.getSelectionModel().select("Oral");
    //Init Semester
    semesterField.getItems().removeAll(semesterField.getItems());
    semesterField.getItems().addAll("1","2","3","4");
    semesterField.getSelectionModel().select("1");
    //Init Group


    groupField.getItems().add("----Select Group----");
    groupField.getSelectionModel().select("----Select Group----");
    files.readGroupList();
    for(int i=0;i<files.getGroupList().size();i++)
    {
      if(files.getGroupList().getGroup(i).getSemester() == 1)
      {
        groupField.getItems().add(files.getGroupList().getGroup(i).getName());
      }}


    //Init Course
    courseField.getItems().removeAll(courseField.getItems());
    courseField.getItems().addAll("SDJ1","SSE1","SEP1","MSE1","RWD1");
    courseField.getSelectionModel().select("SDJ1");
  }

  //Date Management
  public Date getDateStart(){
    LocalDate isoDate = dateField.getValue();
    ChronoLocalDate chronoDate =
        ((isoDate != null) ? dateField.getChronology().date(isoDate) : null);
   // System.err.println("Selected date: " + chronoDate);
    String[] split = chronoDate.toString().split("-");
    int year = Integer.parseInt(split[0]);
    int month = Integer.parseInt(split[1]);
    int day = Integer.parseInt(split[2]);
    String[] timeStartS = timeStart.getText().split(":",2);
    int startH = Integer.parseInt(timeStartS[0]);
    int startM = Integer.parseInt(timeStartS[1]);

    return new Date(day,month,year,startH,startM);
  }

  public Date getDateEnd(){
    LocalDate isoDate = dateField2.getValue();
    ChronoLocalDate chronoDate =
        ((isoDate != null) ? dateField2.getChronology().date(isoDate) : null);
    String[] split = chronoDate.toString().split("-");
    int year = Integer.parseInt(split[0]);
    int month = Integer.parseInt(split[1]);
    int day = Integer.parseInt(split[2]);
    String[] timeEndS = timeEnd.getText().split(":",2);
    int endH = Integer.parseInt(timeEndS[0]);
    int endM = Integer.parseInt(timeEndS[1]);
    return new Date(day,month,year,endH,endM);
  }

  public DateInterval getDateInterval(){

    return new DateInterval(getDateStart(),getDateEnd());
  }




  public void initializeRoom(ActionEvent event) throws FileNotFoundException
  {
    roomList = new RoomList(); //Todo: getRoomList from file instead
    roomField.getItems().removeAll(roomField.getItems());
    roomField.getItems().add("----Add Room----");
    roomField.getSelectionModel().select("----Add Room----");
    ManageExamFiles files = new ManageExamFiles();
    files.readRoomList();
    for (int i = 0; i < model.getAllAvailableRooms(getDateInterval()).size(); i++) {
        roomField.getItems().add(
            model.getAllAvailableRooms(getDateInterval()).get(i).getNumber());
      }
  }


  public void isDateBefore(ActionEvent event)
  {
  }

  public void validateDate(KeyEvent keyEvent)
  {
  }

  public void refreshCourseAndGroup(ActionEvent event)
      throws FileNotFoundException
  {
    ManageExamFiles files = new ManageExamFiles();
    files.readGroupList();
    groupField.getItems().removeAll((groupField.getItems()));
    groupField.getItems().add("---SelectGroup---");
    groupField.getSelectionModel().select("---SelectGroup---");
    for(int i=0;i<files.getGroupList().size();i++)
    {
      if(files.getGroupList().getGroup(i).getSemester() == Integer.parseInt(semesterField.getSelectionModel().getSelectedItem()))
      {
        groupField.getItems().add(files.getGroupList().getGroup(i).getName());
      }}
    if(semesterField.getSelectionModel().getSelectedItem().toString().equals("1")) {
      courseField.getItems().removeAll(courseField.getItems());
      courseField.getItems().addAll("SDJ1","SSE1","SEP1","MSE1","RWD1");
      courseField.getSelectionModel().select("SDJ1");
    }
    else if(semesterField.getSelectionModel().getSelectedItem().toString().equals("2"))
    {
      courseField.getItems().clear();
      courseField.getItems().removeAll(courseField.getItems());
      courseField.getItems().addAll("SDJ2","SWE1","DBS1","SEP2");
      courseField.getSelectionModel().select("SDJ2");
    }
    else if(semesterField.getSelectionModel().getSelectedItem().toString().equals("3")) {
      courseField.getItems().removeAll(courseField.getItems());
      courseField.getItems().addAll("SDJ3","CAO1","DNP1","SEP3","NES1");
      courseField.getSelectionModel().select("SDJ3");
    }
    else if(semesterField.getSelectionModel().getSelectedItem().toString().equals("4")) {
      courseField.getItems().removeAll(courseField.getItems());
      courseField.getItems().addAll("AND1","ESW1","DAI1","SEP4","INO1");
      courseField.getSelectionModel().select("AND1");
    }
  }
}