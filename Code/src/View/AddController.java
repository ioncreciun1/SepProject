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
  public AddController(){}

  public void init(ViewHandler viewHandler, ManageExamModel model ,Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
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
    ManageExamFiles files = new ManageExamFiles();
    files.readGroupList();
    files.readRoomList();
    boolean validated = false;
    //Todo: Examiners need their own list and then they are selected from the list, checked if available not just input
  int semesterS = Integer.parseInt(semesterField.getSelectionModel().getSelectedItem().toString());
  String courseS = courseField.getSelectionModel().getSelectedItem().toString();
  String groupS = groupField.getSelectionModel().getSelectedItem().toString();
  String[] examiners = examinerField.getText().split(", ",2);
  String examinerS = examiners[0];
  // String examinerS2 = examiners[1];
  String roomS = roomField.getSelectionModel().getSelectedItem().toString();
  String typeS = typeField.getSelectionModel().getSelectedItem().toString();
  String[] timeStartS = timeStart.getText().split(":",2);
  int startH = Integer.parseInt(timeStartS[0]);
  int startM = Integer.parseInt(timeStartS[1]);
  String[] timeEndS = timeEnd.getText().split(":",2);
  int endH = Integer.parseInt(timeEndS[0]);
  int endM = Integer.parseInt(timeEndS[1]);
  DateInterval dateInterval = getDateInterval();
    //System.out.println(dateInterval);
  dateInterval.getStartDate().setTime(startH,startM);
   // System.out.println(getDateInterval());

    System.out.println("Start year: " + dateInterval.getStartDate().getYear() );
    System.out.println("End year: " + dateInterval.getEndDate().getYear() );
  dateInterval.getEndDate().setTime(endH,endM);
  Room room = files.getRoomList().getRoomById(roomS);
  Group group = files.getGroupList().getGroup(semesterS,groupS);
  Examiner examiner = new Examiner(examinerS);
  Course course = files.getGroupList().getCourse(courseS,semesterS,groupS);

  Exam exam = new Exam(dateInterval, room, group, typeS, examiner, course);
  try{
    System.out.println("Go Here");
    errorLabel.setText("");
    model.validateExam(exam);

    files.AddExamList(exam);
    viewHandler.openView("landing");
  }catch (Exception e)
  {
    System.out.println("Some error");
    errorLabel.setText("");
    errorLabel.setText(e.getMessage());
  }




    //Todo: get selections from lists and then create a test Exam
  }

  //Room Management



  @FXML
  public void initialize() throws FileNotFoundException
  {
    //Init Room Dropdown

    roomList = new RoomList(); //Todo: getRoomList from file instead
    roomField.getItems().removeAll(roomField.getItems());
    ManageExamFiles files = new ManageExamFiles();
    files.readRoomList();
    for (int i = 0; i < files.getRoomList().getRoomList().size(); i++) {
      //if(model.isRoomTaken(files.getRoomList().getRoomList().get(i),dateInterval))
      roomField.getItems().add(files.getRoomList().getRoomList().get(i).getNumber());
    }


roomField.getSelectionModel().select(files.getRoomList().getRoomList().get(0).getNumber());
    ///Init Type Dropdown
    typeField.getItems().removeAll(typeField.getItems());
    typeField.getItems().addAll("Oral","Written");
    typeField.getSelectionModel().select("Oral");
    //Init Semester
    semesterField.getItems().removeAll(semesterField.getItems());
    semesterField.getItems().addAll("1","2","3","4");
    semesterField.getSelectionModel().select("1");
    //Init Group
    groupField.getItems().removeAll(groupField.getItems());
    groupField.getItems().addAll("X","Y","Z");
    groupField.getSelectionModel().select("X");
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
    System.err.println("Selected date: " + chronoDate);
    String[] split = chronoDate.toString().split("-");
    int year = Integer.parseInt(split[0]);
    int month = Integer.parseInt(split[1]);
    int day = Integer.parseInt(split[2]);
    return new Date(day,month,2019,0,0);
  }

  public Date getDateEnd(){
    LocalDate isoDate = dateField2.getValue();
    ChronoLocalDate chronoDate =
        ((isoDate != null) ? dateField2.getChronology().date(isoDate) : null);
    System.err.println("Selected date: " + chronoDate);
    String[] split = chronoDate.toString().split("-");
    int year = Integer.parseInt(split[0]);
    int month = Integer.parseInt(split[1]);
    int day = Integer.parseInt(split[2]);
    return new Date(day,month,2019,0,0);
  }

  public DateInterval getDateInterval(){

    return new DateInterval(getDateStart(),getDateEnd());
  }

  public void refreshCourse(ActionEvent event)
  {
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


  public void initializeRoom(ActionEvent event) throws FileNotFoundException
  {
    roomList = new RoomList(); //Todo: getRoomList from file instead
    roomField.getItems().removeAll(roomField.getItems());
    ManageExamFiles files = new ManageExamFiles();
    files.readRoomList();
    for (int i = 0; i < model.getAllAvailableRooms(getDateInterval()).size(); i++) {
      //if(model.isRoomTaken(files.getRoomList().getRoomList().get(i),dateInterval))
      roomField.getItems().add(model.getAllAvailableRooms(getDateInterval()).get(i).getNumber());
    }
  }
}