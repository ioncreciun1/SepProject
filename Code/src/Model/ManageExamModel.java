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
  public int getNumberOfStudentsByGroupAndSemester(String groupName,int semester)
      throws FileNotFoundException;
  public Examiner getTeacherByCourseAndGroup(String course,String Group)
      throws FileNotFoundException;
  public ArrayList<Room> getAllAvailableRooms(DateInterval dateInterval)
      throws FileNotFoundException;
  public ArrayList<Room> GetAllRoomsWithPort(String port);
  public ArrayList<Course> getAllCourses(Group group);
  public boolean isRoomTaken(String room,DateInterval date)
      throws FileNotFoundException;
  public boolean isExaminerTaken(Examiner examiner,DateInterval dateInterval)
      throws FileNotFoundException;
  public boolean isCourseTaken(Course course,Group group);
  public void validateExam(Exam exam) throws FileNotFoundException;
  public void addGroup(Group group);
  public Group getGroup(int index);
  public Group getGroup(Group group);
  public ArrayList<Group> getGroupsBySemester(int semester);
  public Room getRoomByName(String name);
}
