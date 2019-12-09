package Model;

import java.util.ArrayList;

public interface  ManageExamModel
{
  public void addExam(Exam exam);
  public Exam getExam(Exam exam);
  public void removeExam(Exam exam);
  public ExamList getAllExams();
  public Exam getExamsByDate(Date date);
  public void addRoom();
  public ArrayList<Room> getAllAvailableRooms();
  public ArrayList<Room> GetAllRoomsWithPort(String port);
  public void removeExaminer();

}
