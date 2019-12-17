package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface  ManageExamModel
{
  public void addExam(Exam exam);
  public void validateTime(String timeString);
  public boolean isRoomBigEnough(int numberOfStudents,String name)
      throws FileNotFoundException;
  public boolean isRoomSuited(String examType, Room room);
  public int getNumberOfStudentsByGroupAndSemester(String groupName,int semester)
      throws FileNotFoundException;
  public Examiner getTeacherByCourseAndGroup(String course,String Group)
      throws FileNotFoundException;
  public boolean isRoomTaken(String room,DateInterval date)
      throws FileNotFoundException;
  public boolean isExaminerTaken(Examiner examiner,DateInterval dateInterval)
      throws FileNotFoundException;
  public void validateExam(Exam exam) throws FileNotFoundException;
  public boolean IsExamTaken(String course,String group, int semester)
      throws FileNotFoundException;
}
