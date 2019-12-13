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

  @Override public void validateExam(Exam exam) throws FileNotFoundException
  {
    if(isExaminerTaken(exam.getExaminer(),exam.getDateInterval())) throw  new IllegalArgumentException("Examiner is Taken for this Date Interval");

  }


  @Override public boolean isExaminerTaken(Examiner examiner, DateInterval dateInterval)
      throws FileNotFoundException
  {
    ManageExamFiles file = new ManageExamFiles();
    file.ReadExamList();
    for(int i=0;i<file.getList().size();i++)
    {
      if(file.getList().get(i).getExaminer().equals(examiner)
          && (file.getList().get(i).getDateInterval().equals(dateInterval)
          || file.getList().get(i).getDateInterval().isBetween(dateInterval.getStartDate())
          )) return true;
    }
    return false;
  }

  @Override public ArrayList<Group> getGroupsBySemester(int semester)
  {
    return null;
  }

  @Override public Room getRoomByName(String name)
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

  @Override public boolean isRoomTaken(String room,DateInterval dateInterval)
      throws FileNotFoundException
  {
    ManageExamFiles file = new ManageExamFiles();
    file.ReadExamList();

    for(int i=0;i<file.getList().size();i++)
    {

      if(file.getList().get(i).getRoom().getNumber().equals(room)
      && (file.getList().get(i).getDateInterval().equals(dateInterval)
          || file.getList().get(i).getDateInterval().isBetween(dateInterval.getStartDate()))
      )
      {
        return true;
      }
    }
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


  @Override public void addRoom()
  {

  }

  @Override public int getNumberOfStudentsByGroupAndSemester(String groupName,
      int semester) throws FileNotFoundException
  {
    ManageExamFiles file= new ManageExamFiles();
    file.readGroupList();

    for(int i=0;i<file.getGroupList().size();i++)
    {
      if(file.getGroupList().getGroup(i).getSemester() == semester && file.getGroupList().getGroup(i).getName().equals(groupName))
      {
        return file.getGroupList().getGroup(i).getNumberOfStudents();
      }
    }
    return 0;
  }

  @Override public Examiner getTeacherByCourseAndGroup(String course,String group)
      throws FileNotFoundException
  {
    ManageExamFiles file= new ManageExamFiles();
    file.readGroupList();

    for(int i=0;i<file.getGroupList().size();i++)
    {
      if (file.getGroupList().getGroup(i).getName().equals(group))
      {

        for(int j=0;j<file.getGroupList().getGroup(i).getCourses().size();j++)
        {
          if (file.getGroupList().getGroup(i).getCourses().get(j).getCourseName().equals(course))
          {return file.getGroupList().getGroup(i).getCourses().get(j).getTeacher(); }
        }

      }
    }
    return null;
  }

  @Override public ArrayList<Room> getAllAvailableRooms(
      DateInterval dateInterval) throws FileNotFoundException
  {
    ManageExamFiles file = new ManageExamFiles();
    file.readRoomList();
    ArrayList<Room> availableRooms = new ArrayList<>();
    for(int i = 0;i<file.getRoomList().getRoomList().size();i++)
    {
      if(!isRoomTaken(file.getRoomList().getRoomList().get(i).getNumber(),dateInterval)) {
        availableRooms.add(file.getRoomList().getRoomList().get(i));
      }
    }
    return availableRooms;
  }

  @Override public ArrayList<Room> GetAllRoomsWithPort(String port)
  {
    return null;
  }
}
