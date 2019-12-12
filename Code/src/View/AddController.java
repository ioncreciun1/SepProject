package View;

import Model.Date;
import Model.DateInterval;
import Model.Room;
import Model.RoomList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
  private RoomList roomList;

  public TextField semesterField;
  public DatePicker dateField;
  public DatePicker dateField2;
  public ComboBox<String> roomField;
  private Region root;
  private ViewHandler viewHandler;
  public AddController(){}

  public void init(ViewHandler viewHandler,  Region root)
  {
    this.viewHandler = viewHandler;
    this.root = root;
    reset();
    updateRooms();
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
    String semester = semesterField.getText();
    String course = courseField.getText();
    String group = groupField.toString();
    String[] examiners = examinerField.getText().split(", ",2);
    String[] timeStartS = timeStart.getText().split(":",2);
    String[] timeEndS = timeEnd.getText().split(":",2);
    System.out.println(timeEndS);
    System.out.println(timeStartS);
    System.out.println(examiners);
    System.out.println(group);
    System.out.println(semester);
    System.out.println(course);
    System.out.println(getDateInterval().toString());
    //Todo: get selections from lists and then create a test Exam
  }

  //Room Management
  public void updateRooms(){
    // TODO: Add rooms to selection
    //String[] roomIds = new String[roomList.getRoomList().size()-1];
    //for (int i = 0; i < roomList.getRoomList().size()-1; i++) {
    //  roomIds[i] = roomList.getRoomList().get(i).getId()+"";
    //}
    //ObservableList<String> list = FXCollections.observableArrayList(roomIds);
    //roomField.setItems(list);
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
