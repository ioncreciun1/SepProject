package View;

import Model.*;
import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Region;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.Locale;

public class EditController
{
  private ManageExamFiles files;
  public DatePicker dateEnd,dateStart;
  public TextField semesterField;
  public TextField groupField;
  public ComboBox roomField;
  public TextField timeStart;
  public TextField timeEnd;
  public TextField examinerField;
  public TextField courseField;
  public ComboBox typeField;
  public Label errorLabel;
  private Exam selectedExam;
  private ManageExamModel model;
  private Region root;
  private ViewHandler viewHandler;
  public EditController(){}
  public void init(ViewHandler viewHandler, ManageExamModel model, Region root) throws FileNotFoundException {

    this.viewHandler = viewHandler;
    this.root = root;
    this.model = model;
    initExam();
    reset();
  }
  public void initExam() throws FileNotFoundException {
    selectedExam = viewHandler.getSelectedExam();
    System.out.println(selectedExam);
    Date startDate = selectedExam.getDateInterval().getStartDate();
    Date endDate = selectedExam.getDateInterval().getEndDate();
    LocalDate startLocal = LocalDate.of(startDate.getYear(),startDate.getMonth(),startDate.getDay());
    LocalDate endLocal = LocalDate.of(endDate.getYear(),endDate.getMonth(),endDate.getDay());
    semesterField.setText(selectedExam.getGroup().getSemester()+"");
    semesterField.setEditable(false);
    dateStart.setValue(startLocal);
    dateEnd.setValue(endLocal);
    courseField.setText(selectedExam.getCourse().getCourseName());
    courseField.setEditable(false);
    groupField.setText(selectedExam.getGroup().getName());
    groupField.setEditable(false);
    typeField.getItems().removeAll(typeField.getItems());
    typeField.getItems().addAll("Oral","Written","Oral/Written");
    typeField.getSelectionModel().select(selectedExam.getType());
    roomField.getItems().removeAll(roomField.getItems());
    files = new ManageExamFiles();
    files.readRoomList();
    for (int i = 0; i < files.getRoomList().getRoomList().size(); i++) {
      //if(model.isRoomTaken(files.getRoomList().getRoomList().get(i),dateInterval))
      roomField.getItems().add(files.getRoomList().getRoomList().get(i).getNumber());
    }
    roomField.getSelectionModel().select(selectedExam.getRoom().getNumber());
    timeStart.setText(startDate.getHour()+":"+getMinute(startDate.getMinute()));
    timeEnd.setText(endDate.getHour()+":"+getMinute(endDate.getMinute()));
    examinerField.setText(selectedExam.getExaminer().getName());
  }
  public String getMinute(int minute){
    if (minute < 10){
      return "0"+minute;
    }else{
      return minute+"";
    }
  }
  public void reset() {
    errorLabel.setText("");
  }

  public Region getRoot()
  {
    return root;
  }

  public void cancel(ActionEvent event) throws FileNotFoundException
  {
    viewHandler.openView("landing");
  }

  public void editExam(MouseEvent mouseEvent) {

    try{
      files.ReadExamList();
      files.readGroupList();
      files.RemoveExamFromList(selectedExam.getCourse().getCourseName(),selectedExam.getGroup().getSemester(),selectedExam.getGroup().getName(),selectedExam.getType());
      errorLabel.setText("");
      String type = typeField.getSelectionModel().getSelectedItem().toString();
      Room room = files.getRoomList().getRoomById(roomField.getSelectionModel().getSelectedItem().toString());
      DateInterval dateInterval = getDateInterval();
      Examiner examiner = new Examiner(examinerField.getText());
      Group group = selectedExam.getGroup();
      Course course = selectedExam.getCourse();
      selectedExam = new Exam(dateInterval,room,group,type,examiner,course);
      model.validateExam(selectedExam);
      files.AddExamList(selectedExam);
      viewHandler.openView("landing");
    }catch (Exception e)
    {
      errorLabel.setText("");
      errorLabel.setText(e.getMessage());
    }
  }
  //Date Management
  public Date getDateStart(){
    LocalDate isoDate = dateStart.getValue();
    ChronoLocalDate chronoDate =
            ((isoDate != null) ? dateStart.getChronology().date(isoDate) : null);
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
    LocalDate isoDate = dateEnd.getValue();
    ChronoLocalDate chronoDate =
            ((isoDate != null) ? dateEnd.getChronology().date(isoDate) : null);
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
}
