package View;

import Model.Exam;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ExamViewModel
{
  private StringProperty courseProperty;
  private StringProperty groupProperty;
  private StringProperty teacherProperty;
  private StringProperty examinerProperty;
  private StringProperty typeProperty;
  private StringProperty roomProperty;
  private IntegerProperty semesterProperty;
  private StringProperty startYearProperty;

  private StringProperty endYearProperty;

  public ExamViewModel(Exam exam)
  {
    courseProperty = new SimpleStringProperty(exam.getCourse().getCourseName());
    this.groupProperty = new SimpleStringProperty(exam.getGroup().getName());
    this.teacherProperty = new SimpleStringProperty(
        exam.getCourse().getTeacher().getName());
    this.examinerProperty = new SimpleStringProperty(
        exam.getExaminer().getName() + "/" + exam.getCourse().getTeacher().getName());
    this.typeProperty = new SimpleStringProperty(exam.getType());
    this.roomProperty = new SimpleStringProperty(exam.getRoom().getNumber());
    this.semesterProperty = new SimpleIntegerProperty(
        exam.getGroup().getSemester());
    this.startYearProperty = new SimpleStringProperty(
        exam.getDateInterval().getStartDate().getYear() +
            "/" + exam.getDateInterval().getStartDate().getMonth() + "/"
            + exam.getDateInterval().getStartDate().getDay() + " " + exam.getDateInterval().getStartDate().getHour() +":" + exam.getDateInterval().getStartDate().getMinute());

    this.endYearProperty = new SimpleStringProperty(
        exam.getDateInterval().getEndDate().getYear() + "/" + exam.getDateInterval().getEndDate().getMonth() + "/" + exam.getDateInterval().getEndDate().getDay() + " " + exam.getDateInterval().getEndDate().getHour() + ":" + exam.getDateInterval().getEndDate().getMinute());

  }


  public StringProperty endYearPropertyProperty()
  {
    return endYearProperty;
  }

  public IntegerProperty semesterPropertyProperty()
  {
    return semesterProperty;
  }





  public StringProperty startYearPropertyProperty()
  {
    return startYearProperty;
  }

  public StringProperty coursePropertyProperty()
  {
    return courseProperty;
  }

  public StringProperty examinerPropertyProperty()
  {
    return examinerProperty;
  }

  public StringProperty groupPropertyProperty()
  {
    return groupProperty;
  }

  public StringProperty roomPropertyProperty()
  {
    return roomProperty;
  }

  public StringProperty teacherPropertyProperty()
  {
    return teacherProperty;
  }

  public StringProperty typePropertyProperty()
  {
    return typeProperty;
  }
}
