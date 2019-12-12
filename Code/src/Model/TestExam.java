package Model;

import java.io.FileNotFoundException;

public class TestExam
{
  public static void main(String[] args) throws FileNotFoundException
  {
    Date date1 = new Date(9, 1, 2000, 9, 30);
    Date date2 = new Date(11, 1, 2000, 12, 30);
    Room room = new Room(true, true, 20, 10, "301.A");
    Examiner teacher1 = new Examiner("Bob");
    Examiner teacher2 = new Examiner("Wade");
    Course course = new Course(teacher1, "SDJ");
    Group group = new Group("Y", 30, 1);

   System.out.println(group);
    Date date3 = new Date(10,1,2000,8,30);

    DateInterval dateInterval = new DateInterval(date1, date2);
    Exam testExam = new Exam(dateInterval, room, group, "Written", teacher2, course);
//    System.out.println(dateInterval.isBetween(date3));
//ManageExamFiles file = new ManageExamFiles();
//file.AddExamList(testExam);
//    ManageExamFiles file = new ManageExamFiles();
//    file.ReadExamList();
//    for(int i=0;i<file.getList().size();i++)
//    {
//      System.out.println(file.getList().get(i));
//    }
   // System.out.println(room);
   // System.out.println(testExam);

    //  ManageExamFiles file = new ManageExamFiles();
    //  file.ReadExamList();
    //    System.out.println(file.getList().size());
    //  for(int i = 0;i<file.getList().size();i++)
    //  {
    //    System.out.println(file.getList().get(i));
    //  }
    //  }
  }
}
