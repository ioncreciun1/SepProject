package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ManageExamModelManager implements ManageExamModel
{
  private ExamList list;
  public  ManageExamModelManager(){list = new ExamList();}
  @Override public Exam getExam(int index)
  {
    return list.getExam(index);
  }

  @Override public void addExam(Exam exam)
  {

  }

  @Override public Exam getExam(Exam exam)
  {
    return null;
  }

  @Override public void removeExam(Exam exam)
  {
   list.removeExam(exam);
  }

  @Override public ExamList getAllExams()
  {
    return null;
  }

  @Override public Exam getExamsByDate(Date date)
  {
    return null;
  }

  @Override public void addRoom()
  {

  }

  @Override public ArrayList<Room> getAllAvailableRooms()
  {
    return null;
  }

  @Override public ArrayList<Room> GetAllRoomsWithPort(String port)
  {
    return null;
  }

  @Override public void removeExaminer()
  {

  }

  public void ManageExamModelManager()
  {

  }
}
