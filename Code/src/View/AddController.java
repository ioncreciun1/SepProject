package View;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.util.StringConverter;

import javax.swing.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.ArrayList;

import java.io.FileNotFoundException;

public class AddController
{

  public TextField courseField;
  public TextField groupField;
  public TextField examinerField;
  public TextField timeEnd;
  public TextField timeStart;
  public ComboBox typeField;
  private RoomList roomList;

  public TextField semesterField;
  public DatePicker dateField;
  public DatePicker dateField2;
  public ComboBox roomField;
  private Region root;
  private ViewHandler viewHandler;
  public AddController(){}

  public void init(ViewHandler viewHandler,  Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
  }

  public void reset() {

  }

  public Region getRoot()
  {
    return root;
  }

  public void cancel(ActionEvent event) throws FileNotFoundException
  {
    viewHandler.openView("landing");
  }

  public void addExam(ActionEvent actionEvent) {
    //Todo: Examiners need their own list and then they are selected from the list, checked if available not just input
    String semesterS = semesterField.getText();
    String courseS = courseField.getText();
    String groupS = groupField.getText();
    String[] examiners = examinerField.getText().split(", ",2);
    String examinerS = examiners[0];
    String examinerS2 = examiners[1];
    String roomS = roomField.getSelectionModel().getSelectedItem().toString();
    String[] timeStartS = timeStart.getText().split(":",2);
    int startH = Integer.parseInt(timeStartS[0]);
    int startM = Integer.parseInt(timeStartS[1]);
    String[] timeEndS = timeEnd.getText().split(":",2);
    int endH = Integer.parseInt(timeEndS[0]);
    int endM = Integer.parseInt(timeEndS[1]);


    DateInterval dateInterval = getDateInterval();
    dateInterval.getStartDate().setTime(startH,startM);
    dateInterval.getEndDate().setTime(endH,endM);


    System.out.println(groupS);
    System.out.println(semesterS);
    System.out.println(courseS);
    System.out.println(examinerS);
    System.out.println(examinerS2);
    System.out.println(roomS);
    //Todo: get selections from lists and then create a test Exam
  }

  //Room Management

  @FXML
  public void initialize() {
    //Init Room Dropdown
    roomList = new RoomList(); //Todo: getRoomList from file instead
    roomField.getItems().removeAll(roomField.getItems());
    for (int i = 0; i < roomList.getRoomList().size()-1; i++) {
      roomField.getItems().add(roomList.getRoomList().get(i).getNumber());
    }
    roomField.getSelectionModel().select(roomList.getRoomList().get(0).getNumber());
    //Init Type Dropdown
    typeField.getItems().removeAll(typeField.getItems());
    typeField.getItems().addAll("Mutual","Written");
    typeField.getSelectionModel().select("Mutual");
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
    return new Date(day,month,year,0,0);
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
    return new Date(day,month,year,0,0);
  }

  public DateInterval getDateInterval(){
    return new DateInterval(getDateStart(),getDateEnd());
  }
}
