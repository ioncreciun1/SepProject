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

  @Override public ArrayList<Course> getAllCourses(Group group)
  {
    ArrayList<Course> courses= new ArrayList<>();
    for(int i = 0;i<list.size();i++)
    {
      if(group.equals(list.getExam(i).getGroup()))
      {
        for(int j = 0;j<list.getExam(i).getGroup().getCourses().size();j++) {
          courses.add(list.getExam(i).getGroup().getCourses().get(i));
        }
      }
    }
    return courses;
  }

  @Override public boolean isCourseTaken(Course course, Group group)
  {
    return false;
  }

  @Override public void validateExam(Exam exam)
  {

  }

  @Override public boolean isExaminerTaken(Examiner examiner,
      DateInterval dateInterval)
  {
    return false;
  }

  @Override public ArrayList<Group> getGroupsBySemester(int semester)
  {
    return null;
  }

  @Override public Group getGroup(int index)
  {
    return null;
  }

  @Override public Group getGroup(Group group)
  {
    return null;
  }

  @Override public void addGroup(Group group)
  {

  }

  @Override public boolean isRoomTaken(Room room, DateInterval date)
  {
    return false;
  }

  @Override public void addExam(Exam exam)
  {
list.addExam(exam);
  }

  @Override public Exam getExam(Exam exam)
  {
    return list.getExam(exam);
  }

  @Override public void removeExam(String course)
  {
   list.removeExam(course);
  }

  @Override public ExamList getAllExams()
  {
    return list;
  }

  @Override public Exam getExamsByDateInterval(DateInterval dateInterval)
  {
    return null;
  }

  @Override public void ValidateSemester(int semester)
  {
    if(semester < 7 && semester > 0) throw new IllegalArgumentException("Insert semester again");
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
}
