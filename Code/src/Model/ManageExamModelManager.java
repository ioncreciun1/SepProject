package Model;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ManageExamModelManager implements ManageExamModel
{
  private ExamList list;
  private ManageExamFiles file;
  public  ManageExamModelManager(){list = new ExamList();
  file= new ManageExamFiles();
  }



  @Override public void validateExam(Exam exam) throws FileNotFoundException
  {
    if(isExaminerTaken(exam.getExaminer(),exam.getDateInterval()))
    {
      for(int i = 0;i<file.getExamList().size();i++)
      {
        if(file.getExamList().getExam(i).getExaminer().equals(exam.getExaminer()))
        {
          throw new IllegalArgumentException(
              "Examiner is Taken for this Interval:" + file.getExamList().getExam(i).getDateInterval());
        }
      }
    }
    if(isRoomBigEnough(exam.getGroup().getNumberOfStudents(),exam.getGroup().getName()))
    {
      throw new IllegalArgumentException("Room is not big enough");
    }
    if(isRoomTaken(exam.getRoom().getNumber(),exam.getDateInterval()))
    {
      for(int i=0;i<file.getExamList().size();i++)
      {

        if(file.getExamList().getExam(i).getRoom().getNumber().equals(exam.getRoom().getNumber()))
        {
          throw new IllegalArgumentException("Room is taken for this date Interval:" + file.getExamList().getExam(i).getDateInterval());
        }
      }
    }
    if(exam.getGroup().getName().equals("----Select Group----"))
    {
      throw new IllegalArgumentException("Select a group");
    }
    if(IsExamTaken(exam.getCourse().getCourseName(),exam.getGroup().getName(),exam.getGroup().getSemester()))
    {
      throw new IllegalArgumentException("This Exam is already in the system");
    }
    if(exam.getDateInterval().getEndDate().isBefore(exam.getDateInterval().getStartDate())) {
      throw new IllegalArgumentException("End Date is before Start Date");
    }
    LocalDateTime now = LocalDateTime.now();
    if(exam.getDateInterval().getStartDate().isBefore(new Date(now.getDayOfMonth(),now.getMonthValue(),now.getYear(),now.getHour(),now.getMinute()))){
      throw new IllegalArgumentException("This Date past");
    }

  }
  public void validateTime(String timeString)
  {
    if(!validateTimeHourAndDate(timeString)) {
      throw  new IllegalArgumentException("Set Valid time");
    }
  }
  public boolean validateTimeHourAndDate(String timeString) {
    if (timeString.length() != 5) return false;
    if (!timeString.substring(2, 3).equals(":")) return false;
    int hour = validateNumber(timeString.substring(0, 2));
    int minute = validateNumber(timeString.substring(3));
    if (hour < 0 || hour >= 24) return false;
    if (minute < 0 || minute >= 60) return false;
    return true;
  }

  public int validateNumber(String numberString) {
    try {
      int number = Integer.valueOf(numberString);
      return number;
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  @Override public boolean IsExamTaken(String course, String group, int semester)
      throws FileNotFoundException
  {
    file.ReadExamList();
    for(int i=0;i<file.getExamList().size();i++)
    {
      if (file.getExamList().getExam(i).getCourse().getCourseName().equals(course)
          && file.getExamList().getExam(i).getGroup().getName().equals(group)
          && file.getExamList().getExam(i).getGroup().getSemester() == semester
      )
      {
        return true;
      }
    }
    return false;
  }

  @Override public boolean isExaminerTaken(Examiner examiner, DateInterval dateInterval)
      throws FileNotFoundException
  {
  file.ReadExamList();
    for(int i=0;i<file.getExamList().size();i++)
    {
      if(file.getExamList().getExam(i).getExaminer().equals(examiner)
          && (file.getExamList().getExam(i).getDateInterval().equals(dateInterval)
          || file.getExamList().getExam(i).getDateInterval().isBetween(dateInterval.getStartDate())
          || file.getExamList().getExam(i).getDateInterval().isBetween(dateInterval.getEndDate())
          || (dateInterval.getStartDate().isBefore(file.getExamList().getExam(i).getDateInterval().getStartDate())
               && !dateInterval.getEndDate().isBefore(file.getExamList().getExam(i).getDateInterval().getEndDate()))
          ))
      {
        System.out.println(file.getExamList().getExam(i).getDateInterval().getEndDate());
        return true;
      }
      }
    return false;
  }

  @Override public boolean isRoomTaken(String room,DateInterval dateInterval)
      throws FileNotFoundException
  {

    file.ReadExamList();
    for(int i=0;i<file.getExamList().size();i++)
    {

      if(file.getExamList().getExam(i).getRoom().getNumber().equals(room)
          && (file.getExamList().getExam(i).getDateInterval().equals(dateInterval)
          || file.getExamList().getExam(i).getDateInterval().isBetween(dateInterval.getStartDate())
          || file.getExamList().getExam(i).getDateInterval().isBetween(dateInterval.getEndDate())
          || (dateInterval.getStartDate().isBefore(file.getExamList().getExam(i).getDateInterval().getStartDate())
          && !dateInterval.getEndDate().isBefore(file.getExamList().getExam(i).getDateInterval().getEndDate()))
      ))
      {
        System.out.println("I am here");
        System.out.println("I am here");
        return true;
      }
    }
    return false;
  }

  @Override public void addExam(Exam exam)
  {
    list.addExam(exam);
  }

  @Override public boolean isRoomBigEnough(int numberOfStudents, String name)
      throws FileNotFoundException
  {
    file.readRoomList();
    for(int i=0;i<file.getRoomList().getRoomList().size();i++)
    {
      if(file.getRoomList().getRoomList().get(i).getNumber().equals(name) && file.getRoomList().getRoomList().get(i).getChairs() >= numberOfStudents)
      {
        return true;
      }
    }
    return false;

  }

  @Override public int getNumberOfStudentsByGroupAndSemester(String groupName,
      int semester) throws FileNotFoundException
  {

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
}
