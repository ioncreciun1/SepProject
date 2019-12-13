package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface  ManageExamModel
{
  public Exam getExam(int index) throws FileNotFoundException;
  public void addExam(Exam exam);
  public Exam getExam(Exam exam);
  public void removeExam(String course);
  public ExamList getAllExams();
  public Exam getExamsByDateInterval(DateInterval dateInterval);
  public void addRoom();
  public void ValidateSemester(int semester);
  public ArrayList<Room> getAllAvailableRooms();
  public ArrayList<Room> GetAllRoomsWithPort(String port);
  public ArrayList<Course> getAllCourses(Group group);
  public boolean isRoomTaken(Room room,DateInterval date);
  public boolean isExaminerTaken(Examiner examiner,DateInterval dateInterval);
  public boolean isCourseTaken(Course course,Group group);
  public void validateExam(Exam exam);
  public void addGroup(Group group);
  public Group getGroup(int index);
  public Group getGroup(Group group);
  public ArrayList<Group> getGroupsBySemester(int semester);
}
